package frc.robot.lib;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class SwerveModule extends SubsystemBase {

    private static String name;

    //Declare Objects up Here!

    private static CANSparkMax driveMotor;
    private static RelativeEncoder driveEncoder;


    private static CANSparkMax turnMotor;
    private static RelativeEncoder turnEncoder;

    private static SparkPIDController turnPID;


    private static CANcoder absoluteEncoder;


    public SwerveModule(
        String name,
        int driveID,
        int turnID,
        int absoluteEncoderID,
        double offset,
        boolean invertTurn,
        boolean invertDrive
    ) {
        //Initialize Objects Here !
    }

    public void setModuleState(SwerveModuleState newState) {
        //Some logic stuff here
        setDriveSpeed();
        setTurnAngle();
    }

    public void setDriveSpeed(double speed) {}
    
    public void setTurnAngle(double angle) {}

    public void getModuleAngle() {}

}
