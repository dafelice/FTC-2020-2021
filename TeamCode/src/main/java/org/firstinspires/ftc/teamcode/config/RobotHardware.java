package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/*This code is for identifying hardware! DONT
* use "init" to make function*/

public class RobotHardware {

    //Defining the DriveTrain Motors
    public static DcMotor FrontL;
    public static DcMotor FrontR;
    public static DcMotor BackL;
    public static DcMotor BackR;

    //Defining the Shooter Motors
    public static DcMotor ShooterR;
    public static DcMotor ShooterL;

    public static Gamepad gamepad1;
    public static Gamepad gamepad2;
}
