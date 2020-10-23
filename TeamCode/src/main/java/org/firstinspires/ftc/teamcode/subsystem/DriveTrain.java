package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.RobotHardware;

import static org.firstinspires.ftc.teamcode.config.RobotHardware.BackL;
import static org.firstinspires.ftc.teamcode.config.RobotHardware.BackR;
import static org.firstinspires.ftc.teamcode.config.RobotHardware.FrontL;
import static org.firstinspires.ftc.teamcode.config.RobotHardware.FrontR;

//drivetrain

//once driver is determined we will want to comeback and set each function to their preferred button

public class DriveTrain extends OpMode {
    //calling hardware so that it is linked to actual motors
    //hardware init comes first bc we call it in later functions; this one essential
    public void hardwareInit(HardwareMap hardwareMap) {

        //identifying the integers as motors
        BackL = hardwareMap.dcMotor.get("BackL");
        BackR = hardwareMap.dcMotor.get("BackR");
        FrontL = hardwareMap.dcMotor.get("FrontL");
        FrontR = hardwareMap.dcMotor.get("FrontR");

        //setting motor directions so they go the correct way when driving
        BackL.setDirection(DcMotorSimple.Direction.REVERSE);
        BackR.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontL.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontR.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    //setting the power for strafing
    private void setStrafepower(int Power){
        BackL.setPower(Power);
        BackR.setPower(-Power);
        FrontL.setPower(-Power);
        FrontR.setPower(Power);
    }

    //setting power for motors for Auto
    public void setMotorPower(int Power){
        BackL.setPower(Power);
        BackR.setPower(Power);
        FrontL.setPower(Power);
        FrontR.setPower(Power);
    }

    //coast or float means gradual slow down to stop, not sudden brake
    //normal is holding wheel in spot to stop, coast & float let go and run out
    public void motorCoastMode(){
        BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    //forces motors to stop right away
    public void motorBrakeMode(){
        BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    //takes integer from controller to set motor power
   public void teleopMotorControl(Gamepad gamepad1, Telemetry telemetry){

        //setting the power for forwards/backwards on the left sick y-axis
        //setting the power for right/left on the right stick x-axis
        FrontR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);
        FrontL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x);
        BackR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);
        BackL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x);

        //calling testmotors so we can see whats happening
        testMotors(telemetry);
    }
//telemetry = sends to driverstation

    public void teleopStrafecontrol(Gamepad gamepad1, Telemetry telemetry){

        motorBrakeMode();

        if (gamepad1.right_bumper){
            telemetry.addData("Strafing Right", "True");
            setStrafepower(1);
            motorCoastMode();
            //if right bumper is pressed it turns motors to strafe right
            }
        else if (gamepad1.left_bumper){
            telemetry.addData("Strafing Left" , "True");
            setStrafepower(-1);
            motorCoastMode();
            //if left bumper is pressed it turns motors to strafe left
        }
        else{
            telemetry.addData("Strafe", "False");
            //else nothing happens
        }
    }

    //gets the current rotation of motors
    public void testMotors(Telemetry telemetry){
        telemetry.addData("FrontL", FrontL.getCurrentPosition());
        telemetry.addData("BackL", BackL.getCurrentPosition());
        telemetry.addData("FrontR", FrontR.getCurrentPosition());
        telemetry.addData("BackR", BackR.getCurrentPosition());
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }


}
