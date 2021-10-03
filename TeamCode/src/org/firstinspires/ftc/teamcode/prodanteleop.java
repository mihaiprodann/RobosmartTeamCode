package  org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import virtual_robot.keyboard.KeyState;

@TeleOp(name = "miscare", group = "teleop")

public class prodanteleop extends LinearOpMode {
    @Override
    public void runOpMode() {
        waitForStart();

        DcMotor m1 = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor m2 = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor m3 = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor m4 = hardwareMap.dcMotor.get("back_right_motor");

        while(opModeIsActive()) {
            m1.setPower(gamepad1.left_stick_x);
            m2.setPower(gamepad1.left_stick_x);
        }

        telemetry.update();
    }
}