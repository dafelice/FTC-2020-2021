package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.config.RobotHardware;

public class Shooter extends OpMode {

    public void hardwareInit(HardwareMap hardwareMap) {

        RobotHardware.ShooterL = hardwareMap.dcMotor.get("ShooterL");
        RobotHardware.ShooterR = hardwareMap.dcMotor.get("ShooterR");
    }

    public void shooterPower(double Power) {

        //making a function that will set the motor power
        RobotHardware.ShooterL.setPower(Power);
        RobotHardware.ShooterR.setPower(Power);
    }

    public void shooterControl(Gamepad gamepad1) {

        shooterPower(0);

        if (gamepad1.y) {

            shooterPower(1);
        }
        else {

            shooterPower(0);
        }


    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
