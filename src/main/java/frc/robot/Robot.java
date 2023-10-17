// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or the package after creating this project, you must also
 * update the build.gradle file in the project.
 */
public class Robot extends TimedRobot {
    // Constants
    private final double kDeadzone = 0.1;
    private final byte kLeftXAxis = 0;
    private final byte kLeftYAxis = 1;

    private CANSparkMax motorMaster = new CANSparkMax(11, MotorType.kBrushless);
    private CANSparkMax motorFollower = new CANSparkMax(12, MotorType.kBrushless);

    // private final WPI_TalonFX motor1 = new WPI_TalonFX(1);
    // private final WPI_TalonFX motor2 = new WPI_TalonFX(2);

    // private Orchestra orchestra = new Orchestra(List.of(motor1, motor2),
    // "./assets/music.chrp");

    /*
     * Joystick ports
     * Driver: 0
     * Operator: 1
     */
    private final Joystick joystick = new Joystick(0);

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        // orchestra.loadMusic(".\\assets\\music.chrp");

        motorFollower.follow(motorMaster);
        motorFollower.setInverted(true);
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        // orchestra.play();

        motorMaster.set(Math.abs(joystick.getRawAxis(kLeftYAxis) > kDeadzone ? joystick.getRawAxis(kLeftYAxis) : 0));
    }

    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    // @Override
    // public void testInit() {
    // }

    // @Override
    // public void testPeriodic() {
    // }

    // @Override
    // public void simulationInit() {
    // }

    // @Override
    // public void simulationPeriodic() {
    // }
}
