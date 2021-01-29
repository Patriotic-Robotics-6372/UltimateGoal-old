package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Date: 10/28/2021
 * Author: Joseph Campos
 * Outtake Subsystem
 */
public class Outtake {

    private DcMotor shoot;
    private Servo positioner;
    private double power = 1;
    private double posRing = 30 / 180;
    private double posRing2 = 0/ 180;

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
        shoot.setPower(0);
    }

    /**
     * sets the posistioner to the right place
     * @param power
     */

    public void positioner(double power){
        positioner.setPosition(posRing);
    }

    /**
     * Puts the positioner back to the beginning place for the next ring
     * @param power
     */

    public void posreset(double power){
        positioner.setPosition(posRing2);
    }












}
