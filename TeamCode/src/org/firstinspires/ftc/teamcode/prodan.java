package  org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Autonomie HIT 2021 MPRDN", group = "Autonomie")

public class prodan extends LinearOpMode {

    // pozitie robot
    private int leftPos;
    private int rightPos;

    @Override
    public void runOpMode()
    {
        leftPos = 0;
        rightPos = 0;

        waitForStart();


        DcMotor m1 = hardwareMap.dcMotor.get("back_left_motor");
        DcMotor m2 = hardwareMap.dcMotor.get("front_left_motor");
        DcMotor m3 = hardwareMap.dcMotor.get("front_right_motor");
        DcMotor m4 = hardwareMap.dcMotor.get("back_right_motor");

        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.update();
    }

    public void robotSpeed(DcMotor mo1, DcMotor mo2, DcMotor mo3, DcMotor mo4, double speed)
    {
        mo1.setPower(speed);
        mo2.setPower(speed);
        mo3.setPower(speed);
        mo4.setPower(speed);
    }

    public void setMotors(String direction, DcMotor m1, DcMotor m2, DcMotor m3, DcMotor m4) {
        if(direction.equals("forward")) {
            m1.setDirection(DcMotor.Direction.REVERSE);
            m2.setDirection(DcMotor.Direction.REVERSE);
            m3.setDirection(DcMotor.Direction.FORWARD);
            m4.setDirection(DcMotor.Direction.FORWARD);
        }
        else if(direction.equals("back")) {
            m1.setDirection(DcMotor.Direction.FORWARD);
            m2.setDirection(DcMotor.Direction.FORWARD);
            m3.setDirection(DcMotor.Direction.REVERSE);
            m4.setDirection(DcMotor.Direction.REVERSE);
        }
        else if(direction.equals("right")) {
            m1.setDirection(DcMotor.Direction.FORWARD);
            m2.setDirection(DcMotor.Direction.REVERSE);
            m3.setDirection(DcMotor.Direction.REVERSE);
            m4.setDirection(DcMotor.Direction.FORWARD);
        }
        else if(direction.equals("left")) {
            m1.setDirection(DcMotor.Direction.REVERSE);
            m2.setDirection(DcMotor.Direction.FORWARD);
            m3.setDirection(DcMotor.Direction.FORWARD);
            m4.setDirection(DcMotor.Direction.REVERSE);
        }
    }
    public void drive(String direction, DcMotor mo1, DcMotor mo2, DcMotor mo3, DcMotor mo4,  int leftTarget, int rightTarget, double speed) {
        leftPos += leftTarget;
        rightPos += rightTarget;

        setMotors(direction, mo1, mo2, mo3, mo4);

        // setare pozitie
        mo1.setTargetPosition(leftPos);
        mo2.setTargetPosition(leftPos);
        mo3.setTargetPosition(rightPos);
        mo4.setTargetPosition(rightPos);

        // setare encodere
        mo1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        mo2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        mo3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        mo4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // pornire manevra
        robotSpeed(mo1, mo2, mo3, mo4, speed);

        while(opModeIsActive() && mo1.isBusy() && mo2.isBusy() && mo3.isBusy() && mo4.isBusy()) {
            idle();
        }

    }
}