package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystem.Robot;

@TeleOp(name = "RobotTest")
public class RobotTest extends OpMode {

    Robot prBot = new Robot();

    @Override
    public void init() {
        prBot.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            prBot.drawbridge.up();
        }
        prBot.drivetrain.forward(6);
        prBot.drivetrain.pointTurn(Drivetrain.DIRECTION.RIGHT, 2.5);
        prBot.drivetrain.stop();
        
    }


}
