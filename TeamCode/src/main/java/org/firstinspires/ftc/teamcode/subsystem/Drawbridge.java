package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Date: 1/28/21
 * Author: Jacob Marinas
 * The drawbridge subsystem
 */
public class Drawbridge {

    private DcMotor pulleyBoi;
    private double power = 1;

    /**
     * Defines the parts needed for the subsystem
     * @param pB
     */
    public Drawbridge(DcMotor pB) {
        this.pulleyBoi = pB;
    }

    /**
     * Brings the drawbridge mechanism up
     */
    public void up() {
        pulleyBoi.setPower(-power);
    }

    /**
     * Brings the drawbridge mechanism down
     */
    public void down() {
        pulleyBoi.setPower(power);
    }

    /**
     * Stops the drawbridge mchanism
     */
    public void stop() {
        pulleyBoi.setPower(0);
    }

    /**
     * @param power that the drawbridge will operate by
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * @return power that the drawbridge operates by
     */
    public double getPower() {
        return power;
    }
}
