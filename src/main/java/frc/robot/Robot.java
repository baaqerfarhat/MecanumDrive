// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class Robot extends TimedRobot {

  


  private static final int kJoystickChannel = 0;

  private MecanumDrive m_robotDrive;
  private Joystick m_stick;

  @Override
  public void robotInit() {

    WPI_TalonSRX frontLeft = new WPI_TalonSRX(4);
    WPI_TalonSRX rearLeft = new WPI_TalonSRX(3);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(1);
    WPI_TalonSRX rearRight = new WPI_TalonSRX(2);

    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft, frontRight, rearLeft, rearRight);

    m_stick = new Joystick(kJoystickChannel);
  }

  @Override
  public void teleopPeriodic() {
    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.
    m_robotDrive.driveCartesian(-m_stick.getY(), m_stick.getX(), m_stick.getZ(), 0.0);
  }
}
