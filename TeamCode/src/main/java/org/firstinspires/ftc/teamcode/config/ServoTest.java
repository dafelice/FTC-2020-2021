package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ServoTest extends OpMode {

    public void hardwareInit(HardwareMap hardwareMap) {

        RobotHardware.HookR = hardwareMap.servo.get("HookR");
    }




    public void setServoDirection(Servo.Direction){

        RobotHardware.HookR.setDirection(Servo.Direction);
        }


    public void teleopServoControl(Gamepad gamepad1, Telemetry telemetry) {

        if (gamepad1.a = true) {

            telemetry.addData("Servo Forward", "True");
            setServoDirection(forward);
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
