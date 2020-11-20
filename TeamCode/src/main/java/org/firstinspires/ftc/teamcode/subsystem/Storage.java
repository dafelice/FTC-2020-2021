package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.config.RobotHardware;

import static org.firstinspires.ftc.teamcode.config.RobotHardware.StorageL;
import static org.firstinspires.ftc.teamcode.config.RobotHardware.StorageR;

public class Storage extends OpMode {

    public void hardwareInit(HardwareMap hardwareMap){

        RobotHardware.StorageR = hardwareMap.servo.get("StorageR");
        RobotHardware.StorageL = hardwareMap.servo.get("StorageL");
    }

    public void storageIntake(){

    }

    public void storageRotate(int Direction){

    }

    public void storageControl(){

    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
