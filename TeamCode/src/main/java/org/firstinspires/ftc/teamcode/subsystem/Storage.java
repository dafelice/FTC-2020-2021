package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.RobotHardware;

import static org.firstinspires.ftc.teamcode.config.RobotHardware.Servo1;
import static org.firstinspires.ftc.teamcode.config.RobotHardware.Servo2;

public class Storage extends OpMode {

    public void hardwareInit(HardwareMap hardwareMap){

        RobotHardware.IntakeL = hardwareMap.dcMotor.get("IntakeL");
        RobotHardware.IntakeR = hardwareMap.dcMotor.get("IntakeR");
        RobotHardware.Servo1 = hardwareMap.crservo.get("Servo1");
        RobotHardware.Servo2 = hardwareMap.crservo.get("Servo2");
    }

    public void teleopServoControl(Gamepad gamepad1, Telemetry telemetry) {

         if (gamepad1.x){

            Servo1.setPower(.75);
            Servo2.setPower(.75);
        }
        else{

            Servo1.setPower(1);
            Servo2.setPower(1);
            telemetry.addData("Servo Lowered", "False");
        }
    }


    public void setstorageIntake(int Power){

        RobotHardware.IntakeR.setPower(Power);
        RobotHardware.IntakeL.setPower(-Power);
    }

    public void storageRotate(int Direction){

    }

    public void storageControl(Gamepad gamepad1){

        if (gamepad1.a){

            setstorageIntake(1);
        }
        else{

            setstorageIntake(0);
        }

    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
