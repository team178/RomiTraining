// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;
 
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
 
public class TrainingPIDFoward extends CommandBase {
    private final Drivetrain drive;
    private final ___ distance; // Distance we want the robot to travel in inches, this is something we want to be very precise 
 
    private double kP = 3.0;
    private double kD = 0.0; 
    private ___ tolerance; // How much we are allowing a the wheels to be off from each other, this is something we want to be very precise
 
    private ___  error; // How much the wheels are off from each other, thi is something we want to be very precise
    private double motorCorrection;
 
    private double power;
 
    /**
     * Creates a new DriveDistance. This command will drive your your robot for a
     * desired distance at a desired speed.
     *
     * @param distance The number of inches the robot will drive
     * @param drive    The drivetrain subsystem on which this command will run
     */
 
    public TrainingPIDFoward(Drivetrain drive, ___  distance, ___  tolerance) { //Same data type as you defined them in the code above, just fill in
    this.distance = distance;
    this.tolerance = tolerance;
    this.drive = drive;
    addRequirements(drive);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetEncoders();
    power = (distance ___ 0 ? .3 : -.3); //Checking if distance is greater than 0
  }
 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    error = drive.getRightDistanceMeter() - drive.getLeftDistanceMeter();
    if(Math.abs(error) ___ tolerance){ //Checking if the absolute value of error is greater than the tolerance
      motorCorrection = error * kP;
    }
    else{
      motorCorrection = 0;
    }
    
    drive.tankDrivePower(power + motorCorrection, motorCorrection - power);
 
 
  }
 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.tankDrivePower(0, 0);
  }
 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    return Math.abs(drive.getAverageDistanceMeter()) ___ Math.abs(distance); //Checking if the robot’s current traveled distance is greater or equal to the absolute value of the distance we wanted it to travel
  }
}
