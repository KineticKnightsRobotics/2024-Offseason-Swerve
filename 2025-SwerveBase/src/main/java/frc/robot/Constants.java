package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public class Constants {
    
    public class SwerveDrive {
        public static final double chassisWidth  = 22.5;
        public static final double chassisLength = 22.5;

        public static final SwerveDriveKinematics chassisKinematics = new SwerveDriveKinematics(  //Used for converting chassis speed into module speed
            new Translation2d(+chassisLength/2, +chassisWidth/2),
            new Translation2d(-chassisLength/2, +chassisWidth/2),
            new Translation2d(+chassisLength/2, -chassisWidth/2),
            new Translation2d(-chassisLength/2, -chassisWidth/2)
        );
        public static final double chassisWheelRadius = Math.sqrt(chassisLength/2*chassisLength/2 + chassisWidth/2*chassisWidth/2);
    }


    public class SwerveModules {

        public static final double wheelRadius = Units.inchesToMeters(2.0);
        public static final double driveGearRatio = 1.0 / 5.9;
        public static final double turnGearRatio  = 1.0 / (150.0 / 7.0);
        
        public static final double turnConversion = 360 * turnGearRatio;
        public static final double driveConversion = 2*wheelRadius*Math.PI * driveGearRatio;

        public static final boolean invertDrive = false;
        public static final boolean invertTurn  = true; //We use MK4I Swerve Modules, turning motors are installed upside down
        public static final boolean invertGyro  = false;

        public class FrontLeft {
            public static final int driveID = 4;
            public static final int turnID  = 3;
            public static final double absoluteOffset = 0.0;
            public static final int absoluteEncoderID = 6;
        }

        public class FrontRight {
            public static final int driveID = 2;
            public static final int turnID  = 1;
            public static final double absoluteOffset = 0.0;
            public static final int absoluteEncoderID = 8;
        }

        public class BackLeft {
            public static final int driveID = 6;
            public static final int turnID  = 5;
            public static final double absoluteOffset = 0.0;
            public static final int absoluteEncoderID = 5;

        }
        public class BackRight {
            public static final int driveID = 8;
            public static final int turnID  = 7;
            public static final double absoluteOffset = 0.0;
            public static final int absoluteEncoderID = 7;
        }
    }


    /*
     *     public static final int ID_FRONT_LEFT_ENCODER_ABSOLUTE  = 6;
    public static final int ID_BACK_LEFT_ENCODER_ABSOLUTE   = 8;
    public static final int ID_FRONT_RIGHT_ENCODER_ABSOLUTE = 5;
    public static final int ID_BACK_RIGHT_ENCODER_ABSOLUTE  = 7;
     */




 /*   
 public static final class KinematicsConstants {
    public static final double KINEMATICS_CHASSIS_WIDTH = Units.inchesToMeters(22.5); // Distance between right and left wheels
    public static final double KINEMATICS_CHASSIS_LENGTH = Units.inchesToMeters(22.5); // Distance between front and back wheels
    public static final SwerveDriveKinematics KINEMATICS_DRIVE_CHASSIS = new SwerveDriveKinematics(
      new Translation2d(+KINEMATICS_CHASSIS_WIDTH / 2, +KINEMATICS_CHASSIS_LENGTH / 2),
      new Translation2d(+KINEMATICS_CHASSIS_WIDTH / 2, -KINEMATICS_CHASSIS_LENGTH / 2),
      new Translation2d(-KINEMATICS_CHASSIS_WIDTH / 2, +KINEMATICS_CHASSIS_LENGTH / 2),
      new Translation2d(-KINEMATICS_CHASSIS_WIDTH / 2, -KINEMATICS_CHASSIS_LENGTH / 2)
    );
    public static final double RADIUS_DRIVE_CHASSIS = Math.sqrt((KINEMATICS_CHASSIS_LENGTH/2)*(KINEMATICS_CHASSIS_LENGTH/2) + (KINEMATICS_CHASSIS_WIDTH/2)*(KINEMATICS_CHASSIS_WIDTH/2));
  }

  public static final class ModuleConstants {

    //Robot Geometry
    public static final double MODULE_WHEEL_DIAMETER = Units.inchesToMeters(4.0);
    public static final double MODULE_DRIVE_GEAR_RATIO = 5.9 / 1.0; // Drive ratio of 8.14 : 1
    public static final double MODULE_TURN_GEAR_RATIO = 1.0 / (150.0 / 7.0); // Turning ratio of (150 / 7) : 1
    public static final double MODULE_DRIVE_ROTATIONS_TO_METERS = ((MODULE_WHEEL_DIAMETER * Math.PI) / MODULE_DRIVE_GEAR_RATIO);//1.05; //1.0475;/// 0.77; -- multiplier to compensate for tread thickness
    public static final double MODULE_TURN_ROTATION_TO_RADIANS = MODULE_TURN_GEAR_RATIO * 2 * Math.PI;
    public static final double MODULE_DRIVE_RPM_TO_MPS = MODULE_DRIVE_ROTATIONS_TO_METERS / 60.0;
    public static final double TurningEncoderRPM2RadPerSec = MODULE_TURN_ROTATION_TO_RADIANS / 60.0;
}

  public static class SwerveSubsystemConstants {




    /*
    // DRIVE Motor Ports
    public static final int ID_FRONT_LEFT_DRIVE  = 4;
    public static final int ID_BACK_LEFT_DRIVE   = 2;
    public static final int ID_FRONT_RIGHT_DRIVE = 6;
    public static final int ID_BACK_RIGHT_DRIVE  = 8;

    // TURNING Motor Ports
    public static final int ID_FRONT_LEFT_TURN  = 3;
    public static final int ID_BACK_LEFT_TURN   = 1;
    public static final int ID_FRONT_RIGHT_TURN = 5;
    public static final int ID_BACK_RIGHT_TURN  = 7;

    // CANCoder Ids
    public static final int ID_FRONT_LEFT_ENCODER_ABSOLUTE  = 6;
    public static final int ID_BACK_LEFT_ENCODER_ABSOLUTE   = 8;
    public static final int ID_FRONT_RIGHT_ENCODER_ABSOLUTE = 5;
    public static final int ID_BACK_RIGHT_ENCODER_ABSOLUTE  = 7;

    // Invert booleans | We use MK4i modules so the turning motors are inverted
    public static final boolean REVERSED_ENCODER_TURN     = true;
    public static final boolean REVERSED_ENCODER_DRIVE    = false;
    public static final boolean REVERSED_ENCODER_ABSOLUTE = false;
    public static final boolean REVERSED_GYRO             = false;

    // Invert Specific Motors
    public static final boolean REVERSED_FRONT_LEFT_MOTOR_DRIVE  = false;//true;//false;
    public static final boolean REVERSED_FRONT_RIGHT_MOTOR_DRIVE = true;//false;//true;
    public static final boolean REVERSED_BACK_LEFT_MOTOR_DRIVE   = false;//true;//false;
    public static final boolean REVERSED_BACK_RIGHT_MOTOR_DRIVE  = true;//false;//true;

    // Turning encoder offsets
    public static final double OFFSET_FRONT_LEFT_ENCODER_ABSOLUTE  = Math.toRadians(-135.3515 + 180);
    public static final double OFFSET_BACK_LEFT_ENCODER_ABSOLUTE   = Math.toRadians(-153.8964 + 180);
    public static final double OFFSET_FRONT_RIGHT_ENCODER_ABSOLUTE = Math.toRadians(18.98430);
    public static final double OFFSET_BACK_RIGHT_ENCODER_ABSOLUTE  = Math.toRadians(152.1386);

    // Robot drive speeds
    public static final double LIMIT_HARD_SPEED_DRIVE = Units.feetToMeters(17.385); // hard limit for speed of chassis
    public static final double LIMIT_SOFT_SPEED_DRIVE = Units.feetToMeters(17.385); // soft limit for speed of chassis

    // Robot turning speeds
    public static final double LIMIT_SOFT_SPEED_TURN =  2.5*Math.PI; // soft limit for module rotation
    */
}
