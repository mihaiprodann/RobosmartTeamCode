package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HMap {
    public DcMotor back_left = null;
    public DcMotor front_left = null;
    public DcMotor front_right = null;
    public DcMotor back_right = null;
    public DcMotor Arm = null;
    public DcMotor carousel = null;
    public DcMotor ramp = null;

    HardwareMap hwmap = null;
    public ElapsedTime runtime = new ElapsedTime();

    //public void FreightFrenzyHardwareMap() {}

    public void init(HardwareMap hmap) {
        /* TODO: de modificat ordinea */
        hwmap = hmap;

        // Motoare roti
        back_left = hwmap.get(DcMotor.class, "stangaspate");
        front_left = hwmap.get(DcMotor.class, "stangafata");
        front_right = hwmap.get(DcMotor.class, "dreaptafata");
        back_right = hwmap.get(DcMotor.class, "dreaptaspate");

        // Encodere

        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        back_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Motoare auxiliare

        Arm = hwmap.get(DcMotor.class, "brat");
        carousel = hwmap.get(DcMotor.class, "carusel");
        ramp = hwmap.get(DcMotor.class, "rampa");

        // Initializare

        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Setare motoare sa nu se miste plm

        back_left.setPower(0);
        front_left.setPower(0);
        front_right.setPower(0);
        back_right.setPower(0);

    }



}
