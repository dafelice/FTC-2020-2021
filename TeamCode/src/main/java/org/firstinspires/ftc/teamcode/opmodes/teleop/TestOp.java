package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;

//tells bot the name of this OpMode, and where it is stored
@TeleOp(name = "TestOp mode by Jack",group = "TeleOp")

//cant have same as package, "TestOp" is name
public class TestOp extends OpMode {

    //private = other codes cannot call from this one, vs public can
    //called a reference, calling it here
    //driveTrain is an "object", the method of DriveTrain class that we use to call
    private static DriveTrain driveTrain = new DriveTrain();

    @Override
    //this is what it does at start - initializes this
    public void init() {
        //driveTrain is calling from other code
        //hardwareInit is specific function from driveTrain
        //hardwareMap is how the OpMode is mapped, identifying/defining the motors (DcMotor stuff)
        driveTrain.hardwareInit(hardwareMap);
        driveTrain.motorBrakeMode();
    }

    @Override
    //loop is for linking and pulling data between controls and motors
    public void loop() {
        //calls when we connected the motors to the controller
        //driveTrain references to other code
        //teleopMotorControl is function, gamepad is linking to
        driveTrain.teleopMotorControl(gamepad1, telemetry);
        //telemetry prints data out on driverstation
        driveTrain.teleopStrafecontrol(gamepad1,telemetry);
    }
}
