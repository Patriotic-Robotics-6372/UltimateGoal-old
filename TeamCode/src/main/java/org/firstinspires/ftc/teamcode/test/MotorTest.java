package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "MotorTest")
public class MotorTest extends LinearOpMode {

    private DcMotor motor;

    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("motor");
        waitForStart();
        while (opModeIsActive()) {
            motor.setPower(0.15);
            telemetry.addData("motorEnc", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}
