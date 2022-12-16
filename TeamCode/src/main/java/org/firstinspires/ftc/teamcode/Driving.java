package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// op mode for driving
@TeleOp
public class Driving extends LinearOpMode {
    // front motors
    private DcMotor motorFrontLeft;
    private DcMotor motorFrontRight;

    // back motors
    private DcMotor motorBackLeft;
    private DcMotor motorBackRight;

    @Override
    public void runOpMode() {
        // set front motors
        motorFrontLeft  = hardwareMap.get(DcMotor.class, "Motor Front Left");
        motorFrontRight = hardwareMap.get(DcMotor.class, "Motor Front Right");

        // set back motors
        motorBackLeft  = hardwareMap.get(DcMotor.class, "Motor Back Left");
        motorBackRight = hardwareMap.get(DcMotor.class, "Motor Back Right");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            float stick_x = gamepad1.left_stick_x;
            float stick_y = gamepad1.left_stick_y;

            // left turning
            motorFrontRight.setPower(Math.min((1 - stick_x) * stick_y, 1));
            motorBackLeft.setPower(Math.min((1 - stick_x) * stick_y, 1));

            // right turning
            motorFrontLeft.setPower(Math.min((1 + stick_x) * stick_y, 1));
            motorBackRight.setPower(Math.min((1 + stick_x) * stick_y, 1));

            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
