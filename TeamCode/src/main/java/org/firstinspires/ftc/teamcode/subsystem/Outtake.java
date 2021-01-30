package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Date: 10/28/2021
 * Author: Joseph Campos
 * Outtake Subsystem
 */
public class Outtake implements Constants {

    private DcMotor shoot;
    private Servo positioner;
    private double power;

    /**
     * sets up the subsystem
     * @param sh
     * @param ps
     */
    public Outtake(DcMotor sh, Servo ps){
        shoot = sh;
        positioner = ps;
    }

    /**
     * A set power for the shooter motor
     * @param power
     */
    public void shoot(double power) {
        shoot.setPower(power);

    }

    /**
     * Makes the shooter motor stop
     * @param power
     */
    public void stop(double power){
        shoot.setPower(STOP);
    }

    /**
     * sets the posistioner to the right place
     */
    public void positioner(){
        positioner.setPosition(posRing);
    }

    /**
     * Puts the positioner back to the beginning place for the next ring
     * @param power
     */

    public void posReset(double power){
        positioner.setPosition(posRing2);
    }

    public void setPower(double power) {
        this.power = power;
    }

    public DcMotor getShoot() { return shoot; }

    public Servo getPositioner() { return positioner; }

    public double getPower() {
        return power;
    }
}
