package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.RobotHardware;

//drivetrain

public class DriveTrain extends OpMode {
    //calling hardware so that it is linked to actual motors
    //hardware init comes first bc we call it in later functions; this one essential
    public void hardwareInit(HardwareMap hardwareMap){

        //identifying the integers as motors
        RobotHardware.BackL = hardwareMap.dcMotor.get("BackL");
        RobotHardware.BackR = hardwareMap.dcMotor.get("BackR");
        RobotHardware.FrontL = hardwareMap.dcMotor.get("FrontL");
        RobotHardware.FrontR = hardwareMap.dcMotor.get("FrontR");

        //setting motor directions so they go the correct way when driving
        RobotHardware.BackL.setDirection(DcMotorSimple.Direction.REVERSE);
        RobotHardware.BackR.setDirection(DcMotorSimple.Direction.FORWARD);
        RobotHardware.FrontL.setDirection(DcMotorSimple.Direction.REVERSE);
        RobotHardware.FrontR.setDirection(DcMotorSimple.Direction.FORWARD);

        //making it so it stops immediately - opposite of coast mode
        motorBrakeMode();
    }

    //use motorpower to set power to motors for driving forward, etc
    public void setMotorPower(int Power){

        RobotHardware.BackL.setPower(Power);
        RobotHardware.BackR.setPower(Power);
        RobotHardware.FrontL.setPower(Power);
        RobotHardware.FrontR.setPower(Power);
    }

    //double power means more fine tuned power - like decimals
    //bc of how strafe drive works, you need to reverse two of the motors
    //private bc we dont need these anywhere else

   /* private void setRightStrafePower(int Power){
        RobotHardware.BackL.setPower(-Power);
        RobotHardware.BackR.setPower(Power);
        RobotHardware.FrontL.setPower(Power);
        RobotHardware.FrontR.setPower(-Power);
    }

    //opposite powers to go in opposite direction
    private void setLeftStrafePower(int Power){
        RobotHardware.BackL.setPower(Power);
        RobotHardware.BackR.setPower(-Power);
        RobotHardware.FrontL.setPower(-Power);
        RobotHardware.FrontR.setPower(Power);
    } */
    //for else if statement to see if current statement is causing motors to fight
    private void setStrafepower(int Power){
        RobotHardware.BackL.setPower(-Power);
        RobotHardware.BackR.setPower(Power);
        RobotHardware.FrontL.setPower(Power);
        RobotHardware.FrontR.setPower(-Power);
    }
    //coast or float means gradual slow down to stop, not sudden brake
    //normal is holding wheel in spot to stop, coast & float let go and run out
    public void motorCoastMode(){
        RobotHardware.BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RobotHardware.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RobotHardware.FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RobotHardware.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void motorBrakeMode(){
        RobotHardware.BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotHardware.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotHardware.FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotHardware.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    //takes integer from controller to set motor power
   public void teleopMotorControl(Gamepad gamepad1, Telemetry telemetry){

        RobotHardware.FrontR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);
        RobotHardware.FrontL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x);
        RobotHardware.BackR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);
        RobotHardware.BackL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x);

        //calling testmotors so we can see whats happening
        testMotors(telemetry);
    }
//telemetry = sends to driverstation
    /*public void 3teleopStrafeControl(Gamepad gamepad1, Telemetry telemetry){
        if (gamepad1.right_bumper){
            //saying if right bumper pressed, strafe right is true, if else then false
            telemetry.addData("Strafing Right", "True");
            //1 is full power, 0 is no power
            setRightStrafePower(1);
        }
        else{
            telemetry.addData("Strafing Right", "False");
        }


        if (gamepad1.left_bumper){
            telemetry.addData("Strafing Left", "True");
            setLeftStrafePower(1);
        }
        else{
            telemetry.addData("Strafing Left", "False");
        }
    }
    */
    public void teleopStrafecontrol(Gamepad gamepad1, Telemetry telemetry){
        if (gamepad1.right_bumper){
            telemetry.addData("Strafing Right", "True");
            setStrafepower(1);
            motorCoastMode();
            }
        else if (gamepad1.left_bumper){
            telemetry.addData("Strafing Right" , "True");
            setStrafepower(-1);
            motorCoastMode();
        }
        else{
            telemetry.addData("Strafe", "False");
        }
    }
    private void testMotors(Telemetry telemetry){
        telemetry.addData("FrontL", RobotHardware.FrontL.getCurrentPosition());
        telemetry.addData("BackL", RobotHardware.BackL.getCurrentPosition());
        telemetry.addData("FrontR", RobotHardware.FrontR.getCurrentPosition());
        telemetry.addData("BackR", RobotHardware.BackR.getCurrentPosition());
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }


}
