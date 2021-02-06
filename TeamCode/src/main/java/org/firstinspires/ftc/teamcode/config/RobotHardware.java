package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/*This code is for identifying hardware! DONT
* use "init" to make function*/

/*Defining all the physical, electrical components of the robot.
I.E. motors, controllers, servos, etc.*/
public class RobotHardware {

    public static DcMotor FrontL;
    public static DcMotor FrontR;
    public static DcMotor BackL;
    public static DcMotor BackR;

    public static DcMotor ShooterR;
    public static DcMotor ShooterL;

    public static Gamepad gamepad1;
    public static Gamepad gamepad2;

    public static DcMotor IntakeR;
    public static DcMotor IntakeL;

    public static CRServo Servo1;
    public static CRServo Servo2;
}