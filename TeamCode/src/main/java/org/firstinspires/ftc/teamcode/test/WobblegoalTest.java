package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Hardware;

import org.firstinspires.ftc.teamcode.subsystem.WobbleGoal;

@TeleOp(name = "WobblegoalTest")
public class WobblegoalTest extends OpMode {
// Joseph Campos Date: 1/21/2021
    WobbleGoal wobbleGoal = new WobbleGoal(hardwareMap.dcMotor.get("wobbleLift"),hardwareMap.crservo.get("wobbleGrabber"),hardwareMap.crservo.get("wobbleGrabber2") );

    @Override
    public void init() {

    }

    /**
     *this is telling the robot to lower the wobble goal contraption
     */
    @Override
        public void loop() {
        /**
         *  this is telling the robot to grab the wobble goal
         */
        if (gamepad1.y){
                wobbleGoal.grab(.5); 
            }else{
                wobbleGoal.stopservos();
            }
        /**
         * this is telling the robot to lift the wobble goal contraption
         */
        if (gamepad1.x){
                wobbleGoal.up(.5);
            }else if (gamepad1.a){
                wobbleGoal.down(.5);
            }else{
                wobbleGoal.stopmotor();
            }



    }
}
