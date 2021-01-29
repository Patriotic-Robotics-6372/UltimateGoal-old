package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Date: 1/28/2021
 * Author: Joseph Campos
 * Wobble Goal subsystem
 */
public class WobbleGoal {
    // Characteristics
    private DcMotor wobbleLift;
    private CRServo wobbleGrabber,wobbleGrabber2;
    // Constructor

    /**
     * Sets up the subsystem
     * @param WL
     * @param WG1
     * @param WG2
     */
    public WobbleGoal(DcMotor WL, CRServo WG1, CRServo WG2){
        wobbleLift = WL;
        wobbleGrabber = WG1;
        wobbleGrabber2 = WG2;
    }

    /**
     * By having a positive power the lift should pull the drawslide up
     */
    public void up(double power){
        wobbleLift.setPower(power);
    }

    /**
     * By having a negative power the lift should make the drawslide go down
     */
    public void down(double power){
        wobbleLift.setPower(-power);
    }

    /**
     * By setting the power to zero the lift will stop
     */
    public void stopmotor(){
        wobbleLift.setPower(0);
    }

    /**
     * Telling the grabbing mechanism to close onto the wobble goal
     */

    public void grab(double power){
        wobbleGrabber.setPower(power);
        wobbleGrabber2.setPower(-power);
    }

    /**
     * Telling the grabbing mechanism to let go of the wobble goal
     */

    public void letGo(double power){
        wobbleGrabber.setPower(-power);
        wobbleGrabber2.setPower(power);
    }

    /**
     * stoping the
     */
    public void stopservos(){
        wobbleGrabber.setPower(0);
        wobbleGrabber2.setPower(0);
    }

    public DcMotor getWobbleLift() {return  wobbleLift;}
    public CRServo getWobbleGrabber() {return wobbleGrabber;}
    public CRServo getWobbleGrabber2() {return wobbleGrabber2; }


// Do you see this if you do it worked































}
