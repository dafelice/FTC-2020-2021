package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.config.RobotHardware;

public class Storage extends OpMode {

    public void hardwareInit(HardwareMap hardwareMap){

        RobotHardware.IntakeL = hardwareMap.dcMotor.get("IntakeL");
        RobotHardware.IntakeR = hardwareMap.dcMotor.get("IntakeR");
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
