
package org.robovm.bindings.parse;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** A Parse Framework Installation Object that is a local representation of an installation persisted to the Parse cloud. This
 * class is a subclass of a PFObject, and retains the same functionality of a PFObject, but also extends it with
 * installation-specific fields and related immutability and validity checks.
 * 
 * A valid PFInstallation can only be instantiated via [PFInstallation currentInstallation] because the required identifier fields
 * are readonly. The timeZone and badge fields are also readonly properties which are automatically updated to match the device's
 * time zone and application badge when the PFInstallation is saved, thus these fields might not reflect the latest device state
 * if the installation has not recently been saved.
 * 
 * PFInstallation objects which have a valid deviceToken and are saved to the Parse cloud can be used to target push
 * notifications.
 * 
 * This class is currently for iOS only. There is no PFInstallation for Parse applications running on OS X, because they cannot
 * receive push notifications. */
@NativeClass
public class PFInstallation extends PFObject implements PFSubclassing {

// /*! The name of the Installation class in the REST API. This is a required
// * PFSubclassing method */
// + (NSString *)parseClassName;
//
// /** @name Targeting Installations */
//
// /*!
// Creates a query for PFInstallation objects. The resulting query can only
// be used for targeting a PFPush. Calling find methods on the resulting query
// will raise an exception.
// */
// + (PFQuery *)query;

    /** Gets the currently-running installation from disk and returns an instance of it. If this installation is not stored on
     * disk, returns a PFInstallation with deviceType and installationId fields set to those of the current installation.
     * @return a PFInstallation that represents the currently-running installation. */
    @Method(selector = "currentInstallation")
    public static native PFInstallation currentInstallation ();

    /** Sets the device token string property from an NSData-encoded token. */
    @Method(selector = "setDeviceTokenFromData:")
    public native void setDeviceToken (NSData deviceTokenData);

    /** @return The device type for the PFInstallation. */
    @Property
    public native String getDeviceType ();

    /** @return The installationId for the PFInstallation. */
    @Property
    public native String getInstallationId ();

    /** @return The device token for the PFInstallation. */
    @Property
    public native String getDeviceToken ();

    @Property
    public native void setDeviceToken (String deviceToken);

// /// The badge for the PFInstallation.
// @property (nonatomic, assign) NSInteger badge;
//
// /// The timeZone for the PFInstallation.
// @property (nonatomic, strong, readonly) NSString *timeZone;

    /** @return The channels for the PFInstallation. */
    @Property
    public native NSArray<NSString> getChannels ();

    @Property
    public native void setChannels (NSArray<NSString> channels);
}
