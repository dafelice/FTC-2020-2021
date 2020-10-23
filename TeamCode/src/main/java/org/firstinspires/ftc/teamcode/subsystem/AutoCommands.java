package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.config.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;

import static org.firstinspires.ftc.teamcode.config.RobotHardware.BackL;
import static org.firstinspires.ftc.teamcode.config.RobotHardware.BackR;
import static org.firstinspires.ftc.teamcode.config.RobotHardware.FrontL;
import static org.firstinspires.ftc.teamcode.config.RobotHardware.FrontR;

public class AutoCommands extends OpMode{

    private DriveTrain driveTrain;

    public AutoCommands(DriveTrain driveTrain){

        this.driveTrain = driveTrain;
    }

    public void init_Auto(int Pos, Telemetry telemetry) {

        //Stop and resets back encoders
        BackL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();

        //Sets motor controls to ticks
        BackR.setTargetPosition(Pos);
        BackL.setTargetPosition(Pos);
        FrontL.setTargetPosition(Pos);
        FrontR.setTargetPosition(Pos);

        //Set encoders to make motors run to determined position
        BackL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void AutoTest() {

        //Sets motor power to full
        driveTrain.setMotorPower(1);

        //Turns left at one full wheel revolution
        if (BackR.getCurrentPosition() == 1120) {

            BackR.setTargetPosition(0);
            BackL.setTargetPosition(2240);
            FrontL.setTargetPosition(2240);
            FrontR.setTargetPosition(0);

            driveTrain.setMotorPower(1);
            driveTrain.testMotors(telemetry);
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}

