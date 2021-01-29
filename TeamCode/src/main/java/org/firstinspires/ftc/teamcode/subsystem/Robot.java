package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Date: 1/28/21
 * Author: Jacob Marinas
 * The robot container class
 */
public class Robot {

    public Drivetrain drivetrain;
    public Drawbridge drawbridge;
    public WobbleGoal wobbleGoal;
    public Intake intake;
    public Outtake outtake;

    public void init(HardwareMap hwMap) {
        drivetrain = new Drivetrain(hwMap.dcMotor.get("frontLeft"), hwMap.dcMotor.get("frontRight"), hwMap.dcMotor.get("backLeft"), hwMap.dcMotor.get("backRight"));
        drawbridge = new Drawbridge(hwMap.dcMotor.get("pulleyBoi"));
        wobbleGoal = new WobbleGoal(hwMap.dcMotor.get("wobbleLift"), hwMap.crservo.get("wobbleGrabber1"), hwMap.crservo.get("wobbleGrabber2"));
        intake = new Intake(hwMap.dcMotor.get("roller"));
        outtake = new Outtake(hwMap.dcMotor.get("shoot"), hwMap.servo.get("positioner"));
    }


}
