package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static org.firstinspires.ftc.teamcode.config.RobotHardware.HookR;

public class ServoTest extends OpMode {

    public void hardwareInit(HardwareMap hardwareMap) {

        HookR = hardwareMap.servo.get("HookR");
    }


    public void teleopServoControl(Gamepad gamepad1, Telemetry telemetry) {

        HookR.setPosition(gamepad1.right_trigger);
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
