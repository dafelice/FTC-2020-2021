package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Auto by Diet Trojanators", group = "Auto")
//LinearOpMode makes it run once then stop
public class AutoCommands extends LinearOpMode {

    DcMotor FrontR;
    DcMotor FrontL;
    DcMotor BackR;
    DcMotor BackL;

    //setting a power mode for the robot to go forward/backward
    private void setMotorPower(int Power){

        BackL.setPower(Power);
        BackR.setPower(Power);
        FrontL.setPower(Power);
        FrontR.setPower(Power);
    }

    //setting a power mode for the robot to turn left
    private void setMotorPowerLeft(int Power){

        BackL.setPower(-Power);
        BackR.setPower(Power);
        FrontL.setPower(-Power);
        FrontR.setPower(Power);
    }

    //Setting a power mode for the robot to turn right
    private void setMotorPowerRight(int Power){

        BackL.setPower(Power);
        BackR.setPower(-Power);
        FrontL.setPower(Power);
        FrontR.setPower(-Power);
    }

    private void setMotorStrafeLeft(int Power){

        BackL.setPower(Power);
        BackR.setPower(-Power);
        FrontL.setPower(-Power);
        FrontR.setPower(Power);
    }

    private void setMotorStrafeRight(int Power){

        BackL.setPower(-Power);
        BackR.setPower(Power);
        FrontL.setPower(Power);
        FrontR.setPower(-Power);
    }

    @Override
    public void runOpMode() throws InterruptedException {

        //init before the start button is pressed
        FrontR = hardwareMap.dcMotor.get("FrontR");
        FrontL = hardwareMap.dcMotor.get("FrontL");
        BackL = hardwareMap.dcMotor.get("BackL");
        BackR = hardwareMap.dcMotor.get("BackR");

        BackL.setDirection(DcMotorSimple.Direction.REVERSE);
        BackR.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontL.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontR.setDirection(DcMotorSimple.Direction.FORWARD);

        //code that is run once the start button is pressed
        waitForStart();

        setMotorPower(1);

        sleep(1000);

        setMotorPower(0);

        sleep(500);

        setMotorStrafeLeft(1);

        sleep(1000);

        setMotorPower(0);

        sleep(500);

        setMotorPower(-1);

        sleep(1000);

        setMotorPower(0);

        sleep(500);

        setMotorStrafeRight(1);

        sleep(1000);

        setMotorPower(0);




    }
}



