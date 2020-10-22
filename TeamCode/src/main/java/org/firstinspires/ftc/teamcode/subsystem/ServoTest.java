package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.RobotHardware;

import static org.firstinspires.ftc.teamcode.config.RobotHardware.HookR;
@TeleOp(name = "ServoTest mode by the Diet Trojantors",group = "TeleOp")

public class ServoTest extends OpMode {


    public void hardwareInit(HardwareMap hardwareMap) {

        RobotHardware.HookR = hardwareMap.servo.get("HookR");
    }


    public void teleopServoControl(Gamepad gamepad1, Telemetry telemetry) {

        RobotHardware.HookR.setPosition(gamepad1.right_trigger);
    }

    @Override
    public void init() {
        hardwareInit(hardwareMap);
    }

    @Override
    public void loop() {
        teleopServoControl(gamepad1, telemetry);
    }
}
