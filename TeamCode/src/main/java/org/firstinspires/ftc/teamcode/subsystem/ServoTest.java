package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.RobotHardware;

import static org.firstinspires.ftc.teamcode.config.RobotHardware.HookR;

public class ServoTest extends OpMode {

    public void hardwareInit(HardwareMap hardwareMap) {

        HookR = hardwareMap.servo.get("HookR");
    }

    public void teleopServoControl(Gamepad gamepad1, Telemetry telemetry) {

        if (gamepad1.a){

          HookR.setPosition(.5);
          telemetry.addData("Servo Lowered", "True");
        }
        else{

           HookR.setPosition(0);
           telemetry.addData("Servo Lowered", "False");
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
