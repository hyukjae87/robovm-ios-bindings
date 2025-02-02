
package org.robovm.bindings.parse;

import org.robovm.apple.foundation.NSError;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.objc.block.VoidBlock2;

/** A Parse Framework User Object that is a local representation of a user persisted to the Parse cloud. This class is a subclass
 * of a PFObject, and retains the same functionality of a PFObject, but also extends it with various user specific methods, like
 * authentication, signing up, and validation uniqueness.
 * 
 * Many APIs responsible for linking a PFUser with Facebook or Twitter have been deprecated in favor of dedicated utilities for
 * each social network. See PFFacebookUtils and PFTwitterUtils for more information. */
@NativeClass
public class PFUser extends PFObject implements PFSubclassing {

    private PFUser () {
    }

//
// /*! The name of the PFUser class in the REST API. This is a required
// * PFSubclassing method */
// + (NSString *)parseClassName;
//
// /** @name Accessing the Current User */
//
    /** Gets the currently logged in user from disk and returns an instance of it.
     * @result Returns a PFUser that is the currently logged in user. If there is none, returns nil. */
    @Method(selector = "currentUser")
    public static native PFUser currentUser ();

    /** The session token for the PFUser. This is set by the server upon successful authentication. */
    @Property
    public native String getSessionToken ();

    @Property
    public native void setSessionToken (String sessionToken);

    /** Whether the PFUser was just created from a request. This is only set after a Facebook or Twitter login. */
    @Property(selector = "isNew")
    public native boolean isNew ();

    /** Whether the user is an authenticated object for the device. An authenticated PFUser is one that is obtained via a signUp or
     * logIn method. An authenticated object is required in order to save (with altered values) or delete it.
     * @return whether the user is authenticated. */
    @Property(selector = "isAuthenticated")
    public native boolean isAuthenticated ();

    /** Creates a new PFUser object.
     * @result Returns a new PFUser object. */
    @Method(selector = "user")
    public static native PFUser create ();

//
// /*!
// Enables automatic creation of anonymous users. After calling this method, [PFUser currentUser] will always have a value.
// The user will only be created on the server once the user has been saved, or once an object with a relation to that user or
// an ACL that refers to the user has been saved.
//
// Note: saveEventually will not work if an item being saved has a relation to an automatic user that has never been saved.
// */
// + (void)enableAutomaticUser;
//
// /// The username for the PFUser.
// @property (nonatomic, strong) NSString *username;
//
// /**
// The password for the PFUser. This will not be filled in from the server with
// the password. It is only meant to be set.
// */
// @property (nonatomic, strong) NSString *password;
//
// /// The email for the PFUser.
// @property (nonatomic, strong) NSString *email;
//
// /*!
// Signs up the user. Make sure that password and username are set. This will also enforce that the username isn't already taken.
// @result Returns true if the sign up was successful.
// */
// - (BOOL)signUp;
//
// /*!
// Signs up the user. Make sure that password and username are set. This will also enforce that the username isn't already taken.
// @param error Error object to set on error.
// @result Returns whether the sign up was successful.
// */
// - (BOOL)signUp:(NSError **)error;
//
// /*!
// Signs up the user asynchronously. Make sure that password and username are set. This will also enforce that the username isn't
// already taken.
// */
// - (void)signUpInBackground;
//
// /*!
// Signs up the user asynchronously. Make sure that password and username are set. This will also enforce that the username isn't
// already taken.
// @param block The block to execute. The block should have the following argument signature: (BOOL succeeded, NSError *error)
// */
// - (void)signUpInBackgroundWithBlock:(PFBooleanResultBlock)block;
//
// /*!
// Signs up the user asynchronously. Make sure that password and username are set. This will also enforce that the username isn't
// already taken.
// @param target Target object for the selector.
// @param selector The selector that will be called when the asynchrounous request is complete. It should have the following
// signature: (void)callbackWithResult:(NSNumber *)result error:(NSError **)error. error will be nil on success and set if there
// was an error. [result boolValue] will tell you whether the call succeeded or not.
// */
// - (void)signUpInBackgroundWithTarget:(id)target selector:(SEL)selector;
//
    /** Makes a request to login a user with specified credentials. Returns an instance of the successfully logged in PFUser. This
     * will also cache the user locally so that calls to currentUser will use the latest logged in user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @result Returns an instance of the PFUser on success. If login failed for either wrong password or wrong username, returns
     *         nil. */
    @Method(selector = "logInWithUsername:password:")
    public static native PFUser logIn (String username, String password);

// /*!
// Makes a request to login a user with specified credentials. Returns an
// instance of the successfully logged in PFUser. This will also cache the user
// locally so that calls to currentUser will use the latest logged in user.
// @param username The username of the user.
// @param password The password of the user.
// @param error The error object to set on error.
// @result Returns an instance of the PFUser on success. If login failed for either wrong password or wrong username, returns nil.
// */
// + (instancetype)logInWithUsername:(NSString *)username
// password:(NSString *)password
// error:(NSError **)error;
//
// /*!
// Makes an asynchronous request to login a user with specified credentials.
// Returns an instance of the successfully logged in PFUser. This will also cache
// the user locally so that calls to currentUser will use the latest logged in user.
// @param username The username of the user.
// @param password The password of the user.
// */
// + (void)logInWithUsernameInBackground:(NSString *)username
// password:(NSString *)password;
//
// /*!
// Makes an asynchronous request to login a user with specified credentials.
// Returns an instance of the successfully logged in PFUser. This will also cache
// the user locally so that calls to currentUser will use the latest logged in user.
// The selector for the callback should look like: myCallback:(PFUser *)user error:(NSError **)error
// @param username The username of the user.
// @param password The password of the user.
// @param target Target object for the selector.
// @param selector The selector that will be called when the asynchrounous request is complete.
// */
// + (void)logInWithUsernameInBackground:(NSString *)username
// password:(NSString *)password
// target:(id)target
// selector:(SEL)selector;
//
// /*!
// Makes an asynchronous request to log in a user with specified credentials.
// Returns an instance of the successfully logged in PFUser. This will also cache
// the user locally so that calls to currentUser will use the latest logged in user.
// @param username The username of the user.
// @param password The password of the user.
// @param block The block to execute. The block should have the following argument signature: (PFUser *user, NSError *error)
// */
// + (void)logInWithUsernameInBackground:(NSString *)username
// password:(NSString *)password
// block:(PFUserResultBlock)block;
//
// /** @name Becoming a user */
//
// /*!
// Makes a request to become a user with the given session token. Returns an
// instance of the successfully logged in PFUser. This also caches the user locally
// so that calls to currentUser will use the latest logged in user.
// @param sessionToken The session token for the user.
// @result Returns an instance of the PFUser on success. If becoming a user fails due to incorrect token, it returns nil.
// */
// + (instancetype)become:(NSString *)sessionToken;
//
// /*!
// Makes a request to become a user with the given session token. Returns an
// instance of the successfully logged in PFUser. This will also cache the user
// locally so that calls to currentUser will use the latest logged in user.
// @param sessionToken The session token for the user.
// @param error The error object to set on error.
// @result Returns an instance of the PFUser on success. If becoming a user fails due to incorrect token, it returns nil.
// */
// + (instancetype)become:(NSString *)sessionToken
// error:(NSError **)error;
//
// /*!
// Makes an asynchronous request to become a user with the given session token. Returns an
// instance of the successfully logged in PFUser. This also caches the user locally
// so that calls to currentUser will use the latest logged in user.
// @param sessionToken The session token for the user.
// */
// + (void)becomeInBackground:(NSString *)sessionToken;
//
// /*!
// Makes an asynchronous request to become a user with the given session token. Returns an
// instance of the successfully logged in PFUser. This also caches the user locally
// so that calls to currentUser will use the latest logged in user.
// The selector for the callback should look like: myCallback:(PFUser *)user error:(NSError **)error
// @param sessionToken The session token for the user.
// @param target Target object for the selector.
// @param selector The selector that will be called when the asynchrounous request is complete.
// */
// + (void)becomeInBackground:(NSString *)sessionToken
// target:(id)target
// selector:(SEL)selector;
//
    /** Makes an asynchronous request to become a user with the given session token. Returns an instance of the successfully logged
     * in PFUser. This also caches the user locally so that calls to currentUser will use the latest logged in user. The selector
     * for the callback should look like: myCallback:(PFUser *)user error:(NSError **)error
     * @param sessionToken The session token for the user.
     * @param block The block to execute. The block should have the following argument signature: (PFUser *user, NSError *error) */
    @Method(selector = "becomeInBackground:block:")
    public static native void becomeInBackground (String sessionToken, @Block VoidBlock2<PFUser, NSError.NSErrorPtr> block);

//
// /** @name Logging Out */
//
// /*!
// Logs out the currently logged in user on disk.
// */
// + (void)logOut;
//
// /** @name Requesting a Password Reset */
//
// /*!
// Send a password reset request for a specified email. If a user account exists with that email,
// an email will be sent to that address with instructions on how to reset their password.
// @param email Email of the account to send a reset password request.
// @result Returns true if the reset email request is successful. False if no account was found for the email address.
// */
// + (BOOL)requestPasswordResetForEmail:(NSString *)email;
//
// /*!
// Send a password reset request for a specified email and sets an error object. If a user
// account exists with that email, an email will be sent to that address with instructions
// on how to reset their password.
// @param email Email of the account to send a reset password request.
// @param error Error object to set on error.
// @result Returns true if the reset email request is successful. False if no account was found for the email address.
// */
// + (BOOL)requestPasswordResetForEmail:(NSString *)email
// error:(NSError **)error;
//
// /*!
// Send a password reset request asynchronously for a specified email and sets an
// error object. If a user account exists with that email, an email will be sent to
// that address with instructions on how to reset their password.
// @param email Email of the account to send a reset password request.
// */
// + (void)requestPasswordResetForEmailInBackground:(NSString *)email;
//
// /*!
// Send a password reset request asynchronously for a specified email and sets an error object.
// If a user account exists with that email, an email will be sent to that address with instructions
// on how to reset their password.
// @param email Email of the account to send a reset password request.
// @param target Target object for the selector.
// @param selector The selector that will be called when the asynchronous request is complete. It should have the following
// signature: (void)callbackWithResult:(NSNumber *)result error:(NSError **)error. error will be nil on success and set if there
// was an error. [result boolValue] will tell you whether the call succeeded or not.
// */
// + (void)requestPasswordResetForEmailInBackground:(NSString *)email
// target:(id)target
// selector:(SEL)selector;
//
// /*!
// Send a password reset request asynchronously for a specified email.
// If a user account exists with that email, an email will be sent to that address with instructions
// on how to reset their password.
// @param email Email of the account to send a reset password request.
// @param block The block to execute. The block should have the following argument signature: (BOOL succeeded, NSError *error)
// */
// + (void)requestPasswordResetForEmailInBackground:(NSString *)email
// block:(PFBooleanResultBlock)block;

    /** Creates a query for PFUser objects. */
    @Method(selector = "query")
    public static native PFQuery getQuery ();
}
