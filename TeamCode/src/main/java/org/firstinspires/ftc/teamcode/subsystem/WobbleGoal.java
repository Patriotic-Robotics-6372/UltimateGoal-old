package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
// Joseph Campos Date: 1/15/2021
public class WobbleGoal {
    // Characteristics
    private DcMotor wobbleLift;
    private CRServo wobbleGrabber,wobbleGrabber2;
    // Constructor

    public WobbleGoal(DcMotor WL, CRServo WG1, CRServo WG2){
        wobbleLift = WL;
        wobbleGrabber = WG1;
        wobbleGrabber2 = WG2;
    }

    //WobbleLift going up
    public void up(double power){
        wobbleLift.setPower(power);
    }

    //WobbleLift going down
    public void down(double power){
        wobbleLift.setPower(-power);
    }

    //WobbleLift Stop
    public void stopmotor(double power){
        wobbleLift.setPower(0);
    }

    //Wobblegrabber close

    public void grab(double power){
        wobbleGrabber.setPower(power);
        wobbleGrabber2.setPower(-power);
    }

    //Wobblegrabber open

    public void letGo(double power){
        wobbleGrabber.setPower(-power);
        wobbleGrabber2.setPower(power);
    }

    //Wobblegrabbers stop
    public void stopservos(double power){
        wobbleGrabber.setPower(0);
        wobbleGrabber2.setPower(0);
    }

































}
