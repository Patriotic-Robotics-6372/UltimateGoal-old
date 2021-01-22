package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drivetrain {

    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private double power, speedPercentage;
    private double TICKS_PER_IN = 1120/(4*Math.PI);
    public int fLTickGoal, fRTickGoal, bLTickGoal, bRTickGoal;
    private int STOP = 0;

    Telemetry telemetry;

    public enum DIRECTION {
        LEFT, RIGHT
    }

    public Drivetrain(DcMotor fL, DcMotor fR, DcMotor bL, DcMotor bR) {
        this.frontLeft = fL;
        this.frontRight = fR;
        this.backLeft = bL;
        this.backRight = bR;

        init();
    }

    private void init() {
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);

        power = STOP;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void useEncoders(boolean use) {
        if (use) {
            setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        } else {
            setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    public void useBrake(boolean use) {
        if (use) {
            setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        } else {
            setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zpb) {
        frontLeft.setZeroPowerBehavior(zpb);
        frontRight.setZeroPowerBehavior(zpb);
        backLeft.setZeroPowerBehavior(zpb);
        backRight.setZeroPowerBehavior(zpb);
    }

    private void setRunMode(DcMotor.RunMode runMode) {
        frontLeft.setMode(runMode);
        frontRight.setMode(runMode);
        backLeft.setMode(runMode);
        backRight.setMode(runMode);
    }

    private void setTargetPos(int fL, int fR, int bL, int bR) {
        frontLeft.setTargetPosition(fL);
        frontRight.setTargetPosition(fR);
        backLeft.setTargetPosition(bL);
        backRight.setTargetPosition(bR);
    }

    public void setPower(double power) { this.power = power; }

    public void setLeftSide(double fL, double bL) {
        frontLeft.setPower(fL);
        backLeft.setPower(bL);
    }

    public void setRightSide(double fR, double bR) {
        frontRight.setPower(fR);
        backRight.setPower(bR);
    }

    public void setBase(double fL, double fR, double bL, double bR) {
        setLeftSide(fL, bL);
        setRightSide(fR, bR);
    }

    public void forward() {
        setBase(-power, -power, -power, -power);
    }

    public void backward() {
        setBase(power, power, power, power);
    }

    public void stop() {
        setBase(STOP, STOP, STOP, STOP);
    }

    public void forward(double inches) {
        drive(-inches, -inches, -inches, -inches, power, power, power, power);
    }

    public void backward(double inches) {
        drive(inches, inches, inches, inches, power, power, power, power);
    }

    public void pivotTurn(DIRECTION dir, double inches) {
        switch (dir) {
            case LEFT:
                drive(0, -inches, 0, -inches, power, power, power, power);
                break;
            case RIGHT:
                drive(-inches, 0, -inches, 0, power, power, power, power);
                break;
        }
    }

    public void pointTurn(DIRECTION dir, double inches) {
        switch (dir) {
            case LEFT:
                drive(inches, -inches, inches, -inches, power, power, power, power);
                break;
            case RIGHT:
                drive(-inches, inches, -inches, inches, power, power, power, power);
                break;
        }
    }

    public void pointTurn(DIRECTION dir) {
        switch (dir) {
            case LEFT:
                setBase(0, -power, 0, -power);
                break;
            case RIGHT:
                setBase(-power, 0, -power, 0);
                break;
        }
    }

    public void pivotTurn(DIRECTION dir) {
        switch (dir) {
            case LEFT:
                setBase(power, -power, power, -power);
                break;
            case RIGHT:
                setBase(-power, power, -power, power);
                break;
        }
    }

    public void drive(double fLInches, double fRInches, double bLInches, double bRInches, double fLPower, double fRPower, double bLPower, double bRPower) {
        fLTickGoal = (int) (fLInches * TICKS_PER_IN);
        fRTickGoal = (int) (fRInches * TICKS_PER_IN);
        bLTickGoal = (int) (bLInches * TICKS_PER_IN);
        bRTickGoal = (int) (bRInches * TICKS_PER_IN);
        setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setTargetPos(fLTickGoal, fRTickGoal, bLTickGoal, bRTickGoal);
        setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        setBase(fLPower, fRPower, bLPower, bRPower);
        while (allBusy()) {

        }
        stop();
        setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    private boolean allBusy() { return frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy(); }

    private boolean anyBusy() { return frontLeft.isBusy() || frontRight.isBusy() || backLeft.isBusy() || backRight.isBusy();}

    public double getPower() { return power; }

    public DcMotor getFrontLeft() { return frontLeft; }

    public DcMotor getFrontRight() { return frontRight; }

    public DcMotor getBackLeft() { return backLeft; }

    public DcMotor getBackRight() { return backRight; }
}
