package  org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "TeleOP", group = "TeleOP")

public class teleop extends LinearOpMode {

    public double   horizontal = 0,
                    vertical = 0,
                    pivot = 0,
                    speed_percent = 1;

    @Override
    public void runOpMode() {

        HMap robot = new HMap();
        robot.init(hardwareMap);

        vertical = -gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;

        robot.back_right.setDirection(DcMotorSimple.Direction.REVERSE);
        robot.front_right.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {
            robot.front_right.setPower(((pivot + (vertical + horizontal)) * speed_percent) / 100);
            robot.front_left.setPower(((pivot + (vertical - horizontal)) * speed_percent) / 100);
            robot.back_left.setPower(((pivot + (vertical - horizontal)) * speed_percent) / 100);
            robot.back_right.setPower(((pivot + (vertical + horizontal)) * speed_percent) / 100);

            if(gamepad1.dpad_up) {
                if(speed_percent <= 90)
                    speed_percent += 10;
            }

            if(gamepad1.dpad_down) {
                if(speed_percent >= 20)
                    speed_percent -= 10;
            }

            telemetry.addData("Robot speed percent: ", speed_percent);

            telemetry.update();
        }

    }
}