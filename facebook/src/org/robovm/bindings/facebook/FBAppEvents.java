
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.bindings.facebook.session.FBSession;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

/** Client-side event logging for specialized application analytics available through Facebook App Insights and for use with
 * Facebook Ads conversion tracking and optimization.
 * 
 * The FBAppEvents static class has a few related roles:
 * 
 * + Logging predefined and application-defined events to Facebook App Insights with a numeric value to sum across a large number
 * of events, and an optional set of key/value parameters that define "segments" for this event (e.g., 'purchaserStatus' :
 * 'frequent', or 'gamerLevel' : 'intermediate')
 * 
 * + Logging events to later be used for ads optimization around lifetime value.
 * 
 * + Methods that control the way in which events are flushed out to the Facebook servers.
 * 
 * Here are some important characteristics of the logging mechanism provided by FBAppEvents:
 * 
 * + Events are not sent immediately when logged. They're cached and flushed out to the Facebook servers in a number of
 * situations: - when an event count threshold is passed (currently 100 logged events). - when a time threshold is passed
 * (currently 60 seconds). - when an app has gone to background and is then brought back to the foreground.
 * 
 * + Events will be accumulated when the app is in a disconnected state, and sent when the connection is restored and one of the
 * above 'flush' conditions are met.
 * 
 * + The FBAppEvents class in thread-safe in that events may be logged from any of the app's threads.
 * 
 * + The developer can set the flushBehavior on FBAppEvents to force the flushing of events to only occur on an explicit call to
 * the {@link #flush()} method.
 * 
 * + The developer can turn on console debug output for event logging and flushing to the server by using the
 * `FBLoggingBehaviorAppEvents` value in `[FBSettings setLoggingBehavior:]`.
 * 
 * Some things to note when logging events:
 * 
 * + There is a limit on the number of unique event names an app can use, on the order of 300. + There is a limit to the number of
 * unique parameter names in the provided parameters that can be used per event, on the order of 10. This is not just for an
 * individual call, but for all invocations for that eventName. + Event names and parameter names (the keys in the NSDictionary)
 * must be between 2 and 40 characters, and must consist of alphanumeric characters, _, -, or spaces. + The length of each
 * parameter value can be no more than on the order of 100 characters. */
@Library(Library.INTERNAL)
@NativeClass
public class FBAppEvents extends NSObject {
//
// /*
// * Constant used by NSNotificationCenter for results of flushing AppEvents event logs
// */
//
// /*! NSNotificationCenter name indicating a result of a failed log flush attempt */
// extern NSString *const FBAppEventsLoggingResultNotification;
//
//
// // Predefined event names for logging events common to many apps. Logging occurs through the logEvent family of methods on
// FBAppEvents.
// // Common event parameters are provided in the FBAppEventsParameterNames* constants.
//
// // General purpose
//
// /*! Log this event when an app is being activated, typically in the AppDelegate's applicationDidBecomeActive. */
// extern NSString *const FBAppEventNameActivatedApp;
//
// /*! Log this event when a user has completed registration with the app. */
// extern NSString *const FBAppEventNameCompletedRegistration;
//
// /*! Log this event when a user has viewed a form of content in the app. */
// extern NSString *const FBAppEventNameViewedContent;
//
// /*! Log this event when a user has performed a search within the app. */
// extern NSString *const FBAppEventNameSearched;
//
// /*! Log this event when the user has rated an item in the app. The valueToSum passed to logEvent should be the numeric rating.
// */
// extern NSString *const FBAppEventNameRated;
//
// /*! Log this event when the user has completed a tutorial in the app. */
// extern NSString *const FBAppEventNameCompletedTutorial;
//
// // Ecommerce related
//
// /*! Log this event when the user has added an item to their cart. The valueToSum passed to logEvent should be the item's price.
// */
// extern NSString *const FBAppEventNameAddedToCart;
//
// /*! Log this event when the user has added an item to their wishlist. The valueToSum passed to logEvent should be the item's
// price. */
// extern NSString *const FBAppEventNameAddedToWishlist;
//
// /*! Log this event when the user has entered the checkout process. The valueToSum passed to logEvent should be the total price
// in the cart. */
// extern NSString *const FBAppEventNameInitiatedCheckout;
//
// /*! Log this event when the user has entered their payment info. */
// extern NSString *const FBAppEventNameAddedPaymentInfo;
//
// /*! Log this event when the user has completed a purchase. The `[FBAppEvents logPurchase]` method is a shortcut for logging
// this event. */
// extern NSString *const FBAppEventNamePurchased;
//
// // Gaming related
//
// /*! Log this event when the user has achieved a level in the app. */
// extern NSString *const FBAppEventNameAchievedLevel;
//
// /*! Log this event when the user has unlocked an achievement in the app. */
// extern NSString *const FBAppEventNameUnlockedAchievement;
//
// /*! Log this event when the user has spent app credits. The valueToSum passed to logEvent should be the number of credits
// spent. */
// extern NSString *const FBAppEventNameSpentCredits;
//
//
//
// // Predefined event name parameters for common additional information to accompany events logged through the logEvent family
// // of methods on FBAppEvents. Common event names are provided in the FBAppEventName* constants.
//
// /*! Parameter key used to specify currency used with logged event. E.g. "USD", "EUR", "GBP". See ISO-4217 for specific values.
// One reference for these is <http://en.wikipedia.org/wiki/ISO_4217>. */
// extern NSString *const FBAppEventParameterNameCurrency;
//
// /*! Parameter key used to specify method user has used to register for the app, e.g., "Facebook", "email", "Twitter", etc */
// extern NSString *const FBAppEventParameterNameRegistrationMethod;
//
// /*! Parameter key used to specify a generic content type/family for the logged event, e.g. "music", "photo", "video". Options
// to use will vary based upon what the app is all about. */
// extern NSString *const FBAppEventParameterNameContentType;
//
// /*! Parameter key used to specify an ID for the specific piece of content being logged about. Could be an EAN, article
// identifier, etc., depending on the nature of the app. */
// extern NSString *const FBAppEventParameterNameContentID;
//
// /*! Parameter key used to specify the string provided by the user for a search operation. */
// extern NSString *const FBAppEventParameterNameSearchString;
//
// /*! Parameter key used to specify whether the activity being logged about was successful or not. `FBAppEventParameterValueYes`
// and `FBAppEventParameterValueNo` are good canonical values to use for this parameter. */
// extern NSString *const FBAppEventParameterNameSuccess;
//
// /*! Parameter key used to specify the maximum rating available for the `FBAppEventNameRate` event. E.g., "5" or "10". */
// extern NSString *const FBAppEventParameterNameMaxRatingValue;
//
// /*! Parameter key used to specify whether payment info is available for the `FBAppEventNameInitiatedCheckout` event.
// `FBAppEventParameterValueYes` and `FBAppEventParameterValueNo` are good canonical values to use for this parameter. */
// extern NSString *const FBAppEventParameterNamePaymentInfoAvailable;
//
// /*! Parameter key used to specify how many items are being processed for an `FBAppEventNameInitiatedCheckout` or
// `FBAppEventNamePurchased` event. */
// extern NSString *const FBAppEventParameterNameNumItems;
//
// /*! Parameter key used to specify the level achieved in a `FBAppEventNameAchieved` event. */
// extern NSString *const FBAppEventParameterNameLevel;
//
// /*! Parameter key used to specify a description appropriate to the event being logged. E.g., the name of the achievement
// unlocked in the `FBAppEventNameAchievementUnlocked` event. */
// extern NSString *const FBAppEventParameterNameDescription;

    /** True-valued parameter value to be used with parameter keys that need a True/False value */
// @GlobalValue(symbol = "FBAppEventParameterValueYes")
// public static native String ParameterValueTrue ();

    /** False-valued parameter value to be used with parameter keys that need a True/False value */
// @GlobalValue(symbol = "FBAppEventParameterValueNo")
// public static native String ParameterValueFalse ();

//
// /*!
//
// @method
//
// @abstract
// Log an event with just an eventName.
//
// @param eventName The name of the event to record. Limitations on number of events and name length
// are given in the FBAppEvents documentation.
//
// */
// + (void)logEvent:(NSString *)eventName;
//
// /*!
//
// @method
//
// @abstract
// Log an event with an eventName and a numeric value to be aggregated with other events of this name.
//
// @param eventName The name of the event to record. Limitations on number of events and name length
// are given in the FBAppEvents documentation. Common event names are provided in FBAppEventName* constants.
//
// @param valueToSum Amount to be aggregated into all events of this eventName, and App Insights will report
// the cumulative and average value of this amount.
// */
// + (void)logEvent:(NSString *)eventName
// valueToSum:(double)valueToSum;
//
//
// /*!
//
// @method
//
// @abstract
// Log an event with an eventName and a set of key/value pairs in the parameters dictionary.
// Parameter limitations are described above.
//
// @param eventName The name of the event to record. Limitations on number of events and name construction
// are given in the FBAppEvents documentation. Common event names are provided in FBAppEventName* constants.
//
// @param parameters Arbitrary parameter dictionary of characteristics. The keys to this dictionary must
// be NSString's, and the values are expected to be NSString or NSNumber. Limitations on the number of
// parameters and name construction are given in the FBAppEvents documentation. Commonly used parameter names
// are provided in `FBAppEventParameterName* constants.
// */
// + (void)logEvent:(NSString *)eventName
// parameters:(NSDictionary *)parameters;
//
// /*!
//
// @method
//
// @abstract
// Log an event with an eventName, a numeric value to be aggregated with other events of this name,
// and a set of key/value pairs in the parameters dictionary.
//
// @param eventName The name of the event to record. Limitations on number of events and name construction
// are given in the FBAppEvents documentation. Common event names are provided in FBAppEventName* constants.
//
// @param valueToSum Amount to be aggregated into all events of this eventName, and App Insights will report
// the cumulative and average value of this amount.
//
// @param parameters Arbitrary parameter dictionary of characteristics. The keys to this dictionary must
// be NSString's, and the values are expected to be NSString or NSNumber. Limitations on the number of
// parameters and name construction are given in the FBAppEvents documentation. Commonly used parameter names
// are provided in FBAppEventParameterName* constants.
//
// */
// + (void)logEvent:(NSString *)eventName
// valueToSum:(double)valueToSum
// parameters:(NSDictionary *)parameters;
//
//
// /*!
//
// @method
//
// @abstract
// Log an event with an eventName, a numeric value to be aggregated with other events of this name,
// and a set of key/value pairs in the parameters dictionary. Providing session lets the developer
// target a particular {@link FBSession}. If nil is provided, then {@link FBSession#getActiveSession()} will be used.
//
// @param eventName The name of the event to record. Limitations on number of events and name construction
// are given in the FBAppEvents documentation. Common event names are provided in FBAppEventName* constants.
//
// @param valueToSum Amount to be aggregated into all events of this eventName, and App Insights will report
// the cumulative and average value of this amount. Note that this is an NSNumber, and a value of {@code null} denotes
// that this event doesn't have a value associated with it for summation.
//
// @param parameters Arbitrary parameter dictionary of characteristics. The keys to this dictionary must
// be NSString's, and the values are expected to be NSString or NSNumber. Limitations on the number of
// parameters and name construction are given in the FBAppEvents documentation. Commonly used parameter names
// are provided in FBAppEventParameterName* constants.
//
// @param session {@link FBSession} to direct the event logging to, and thus be logged with whatever user (if any)
// is associated with that {@link FBSession}.
// */
// + (void)logEvent:(NSString *)eventName
// valueToSum:(NSNumber *)valueToSum
// parameters:(NSDictionary *)parameters
// session:(FBSession *)session;
//
//
// /*
// * Purchase logging
// */

    /** Log a purchase of the specified amount, in the specified currency. This event immediately triggers a flush of the
     * FBAppEvents event queue, unless the flushBehavior is set to `FBAppEventsFlushBehaviorExplicitOnly`.
     * @param purchaseAmount Purchase amount to be logged, as expressed in the specified currency. This value will be rounded to
     *            the thousandths place (e.g., 12.34567 becomes 12.346).
     * @param currency Currency, is denoted as, e.g. "USD", "EUR", "GBP". See ISO-4217 for specific values. One reference for
     *            these is <a href="http://en.wikipedia.org/wiki/ISO_4217">ISO 4217</a>. */
    @Method(selector = "logPurchase:currency:")
    public static native void logPurchase (double purchaseAmount, String currency);

//
// /*!
//
// @method
//
// @abstract
// Log a purchase of the specified amount, in the specified currency, also providing a set of
// additional characteristics describing the purchase.
//
// @param purchaseAmount Purchase amount to be logged, as expressed in the specified currency.This value
// will be rounded to the thousandths place (e.g., 12.34567 becomes 12.346).
//
// @param currency Currency, is denoted as, e.g. "USD", "EUR", "GBP". See ISO-4217 for
// specific values. One reference for these is <http://en.wikipedia.org/wiki/ISO_4217>.
//
// @param parameters Arbitrary parameter dictionary of characteristics. The keys to this dictionary must
// be NSString's, and the values are expected to be NSString or NSNumber. Limitations on the number of
// parameters and name construction are given in the FBAppEvents documentation. Commonly used parameter names
// are provided in FBAppEventParameterName* constants.
//
// @discussion This event immediately triggers a flush of the FBAppEvents event queue, unless the flushBehavior is set
// to {@link FBAppEventsFlushBehavior#ExplicitOnly}.
//
// */
// + (void)logPurchase:(double)purchaseAmount
// currency:(NSString *)currency
// parameters:(NSDictionary *)parameters;

    /** This event immediately triggers a flush of the {@link FBAppEvents} event queue, unless the flushBehavior is set to
     * {@link FBAppEventsFlushBehavior#ExplicitOnly}.
     * 
     * Log a purchase of the specified amount, in the specified currency, also providing a set of additional characteristics
     * describing the purchase, as well as an {@link FBSession} to log to.
     * @param purchaseAmount Purchase amount to be logged, as expressed in the specified currency.This value will be rounded to
     *            the thousandths place (e.g., 12.34567 becomes 12.346).
     * @param currency Currency, is denoted as, e.g. "USD", "EUR", "GBP". See ISO-4217 for specific values. One reference for
     *            these is <http://en.wikipedia.org/wiki/ISO_4217>.
     * @param parameters Arbitrary parameter dictionary of characteristics. The keys to this dictionary must be NSString's, and
     *            the values are expected to be NSString or NSNumber. Limitations on the number of parameters and name
     *            construction are given in the FBAppEvents documentation. Commonly used parameter names are provided in
     *            FBAppEventParameterName* constants.
     * @param session {@link FBSession} to direct the event logging to, and thus be logged with whatever user (if any) is
     *            associated with that {@link FBSession}. A value of {@code null} will use {@link FBSession#getActiveSession()}. */

    @Method(selector = "logPurchase:currency:parameters:session:")
    public static native void logPurchase (double purchaseAmount, String currency, NSDictionary<?, ?> parameters,
        FBSession session);

    /** Notifies the events system that the app has launched & logs an activatedApp event. Should typically be placed in the app
     * delegates' `applicationDidBecomeActive:` method. */

    @Method(selector = "activateApp")
    public static native void activateApp ();

    /** @return Get the current event flushing behavior specifying when events are sent back to Facebook servers. */
    @Method(selector = "flushBehavior")
    public static native FBAppEventsFlushBehavior getFlushBehavior ();

    /** Set the current event flushing behavior specifying when events are sent back to Facebook servers.
     * @param flushBehavior The desired {@link FBAppEventsFlushBehavior} to be used. */
    @Method(selector = "setFlushBehavior:")
    public static native void setFlushBehavior (FBAppEventsFlushBehavior flushBehavior);

    /** Explicitly kick off flushing of events to Facebook. This is an asynchronous method, but it does initiate an immediate kick
     * off. Server failures will be reported through the NotificationCenter with notification ID
     * "FBAppEventsLoggingResultNotification". */
    @Method(selector = "flush")
    public static native void flush ();
}
