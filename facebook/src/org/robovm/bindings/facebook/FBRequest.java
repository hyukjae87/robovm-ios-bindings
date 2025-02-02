
package org.robovm.bindings.facebook;

import java.util.Map;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.bindings.facebook.session.FBSession;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

/** The FBRequest object is used to setup and manage requests to Facebook Graph and REST APIs. This class provides helper methods
 * that simplify the connection and response handling.
 * 
 * An {@link FBSession} object is required for all authenticated uses of FBRequest. Requests that do not require an
 * unauthenticated user are also supported and do not require an {@link FBSession} object to be passed in.
 * 
 * An instance of FBRequest represents the arguments and setup for a connection to Facebook. After creating an FBRequest object it
 * can be used to setup a connection to Facebook through the {@link FBRequestConnection} object. The {@link FBRequestConnection}
 * object is created to manage a single connection. To cancel a connection use the instance method in the
 * {@link FBRequestConnection} class.
 * 
 * An FBRequest object may be reused to issue multiple connections to Facebook. However each {@link FBRequestConnection} instance
 * will manage one connection.
 * 
 * Class and instance methods prefixed with **start* ** can be used to perform the request setup and initiate the connection in a
 * single call. */
@NativeClass
public class FBRequest extends NSObject {

	/*
	 * !
	 * 
	 * @methodgroup Creating a request
	 * 
	 * @method Calls <initWithSession:graphPath:parameters:HTTPMethod:> with the default parameters.
	 */
	// - (id)init;

	/*
	 * !
	 * 
	 * @method Calls <initWithSession:graphPath:parameters:HTTPMethod:> with default parameters except for the ones provided to
	 * this method.
	 * 
	 * @param session The session object representing the identity of the Facebook user making the request. A nil value indicates a
	 * request that requires no token; to use the active session pass `[FBSession activeSession]`.
	 * 
	 * @param graphPath The Graph API endpoint to use for the request, for example "me".
	 */
	// - (id)initWithSession:(FBSession*)session
	// graphPath:(NSString *)graphPath;

	/** Initializes an FBRequest object for a Graph API request call.
	 * 
	 * Note that this only sets properties on the `FBRequest` object.
	 * 
	 * To send the request, initialize an {@link FBRequestConnection} object, add this request, and send <[FBRequestConnection
	 * start]>. See other methods on this class for shortcuts to simplify this process.
	 * 
	 * @param session The session object representing the identity of the Facebook user making the request. A nil value indicates a
	 *           request that requires no token; to use the active session pass `[FBSession activeSession]`.
	 * 
	 * @param graphPath The Graph API endpoint to use for the request, for example "me".
	 * 
	 * @param parameters The parameters for the request. A value of nil sends only the automatically handled parameters, for
	 *           example, the access token. The default is nil.
	 * 
	 * @param HTTPMethod The HTTP method to use for the request. The default is value of nil implies a GET. */
	public FBRequest (FBSession session, String graphPath, Map<String, String> parameters, String httpMethod) {
		super((SkipInit)null);
		NSMutableDictionary<NSString, NSString> params = new NSMutableDictionary<NSString, NSString>();
		if (parameters != null) for (Map.Entry<String, String> entry : parameters.entrySet()) {
			params.put(new NSString(entry.getKey()), new NSString(entry.getValue()));
		}
		initObject(init(session, graphPath, params, httpMethod));
	}

	@Method(selector = "initWithSession:graphPath:parameters:HTTPMethod:")
	private native @Pointer
	long init (FBSession session, String graphPath, NSDictionary<NSString, NSString> parameters, String httpMethod);

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Initialize a `FBRequest` object that will do a graph request.
	 * 
	 * @discussion Note that this only sets properties on the `FBRequest`.
	 * 
	 * To send the request, initialize a <FBRequestConnection>, add this request, and send <[FBRequestConnection start]>. See other
	 * methods on this class for shortcuts to simplify this process.
	 * 
	 * @param session The session object representing the identity of the Facebook user making the request. A nil value indicates a
	 * request that requires no token; to use the active session pass `[FBSession activeSession]`.
	 * 
	 * @param graphPath The Graph API endpoint to use for the request, for example "me".
	 * 
	 * @param graphObject An object or open graph action to post.
	 */
	// - (id)initForPostWithSession:(FBSession*)session
	// graphPath:(NSString *)graphPath
	// graphObject:(id<FBGraphObject>)graphObject;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Initialize a `FBRequest` object that will do a rest API request.
	 * 
	 * @discussion Prefer to use graph requests instead of this where possible.
	 * 
	 * Note that this only sets properties on the `FBRequest`.
	 * 
	 * To send the request, initialize a <FBRequestConnection>, add this request, and send <[FBRequestConnection start]>. See other
	 * methods on this class for shortcuts to simplify this process.
	 * 
	 * @param session The session object representing the identity of the Facebook user making the request. A nil value indicates a
	 * request that requires no token; to use the active session pass `[FBSession activeSession]`.
	 * 
	 * @param restMethod A valid REST API method.
	 * 
	 * @param parameters The parameters for the request. A value of nil sends only the automatically handled parameters, for
	 * example, the access token. The default is nil.
	 * 
	 * @param HTTPMethod The HTTP method to use for the request. The default is value of nil implies a GET.
	 */
	// - (id)initWithSession:(FBSession*)session
	// restMethod:(NSString *)restMethod
	// parameters:(NSDictionary *)parameters
	// HTTPMethod:(NSString *)HTTPMethod;

	/*
	 * !
	 * 
	 * @abstract The parameters for the request.
	 * 
	 * @discussion May be used to read the parameters that were automatically set during the object initiliazation. Make any
	 * required modifications prior to sending the request.
	 * 
	 * `NSString` parameters are used to generate URL parameter values or JSON parameters. `NSData` and `UIImage` parameters are
	 * added as attachments to the HTTP body and referenced by name in the URL and/or JSON.
	 */
	// @property (nonatomic, retain, readonly) NSMutableDictionary *parameters;

	/*
	 * !
	 * 
	 * @abstract The <FBSession> session object to use for the request.
	 * 
	 * @discussion May be used to read the session that was automatically set during the object initiliazation. Make any required
	 * modifications prior to sending the request.
	 */
	// @property (nonatomic, retain) FBSession *session;

	/*
	 * !
	 * 
	 * @abstract The Graph API endpoint to use for the request, for example "me".
	 * 
	 * @discussion May be used to read the Graph API endpoint that was automatically set during the object initiliazation. Make any
	 * required modifications prior to sending the request.
	 */
	// @property (nonatomic, copy) NSString *graphPath;

	/*
	 * !
	 * 
	 * @abstract A valid REST API method.
	 * 
	 * @discussion May be used to read the REST method that was automatically set during the object initiliazation. Make any
	 * required modifications prior to sending the request.
	 * 
	 * Use the Graph API equivalent of the API if it exists as the REST API method is deprecated if there is a Graph API
	 * equivalent.
	 */
	// @property (nonatomic, copy) NSString *restMethod;

	/*
	 * !
	 * 
	 * @abstract The HTTPMethod to use for the request, for example "GET" or "POST".
	 * 
	 * @discussion May be used to read the HTTP method that was automatically set during the object initiliazation. Make any
	 * required modifications prior to sending the request.
	 */
	// @property (nonatomic, copy) NSString *HTTPMethod;

	/*
	 * !
	 * 
	 * @abstract The graph object to post with the request.
	 * 
	 * @discussion May be used to read the graph object that was automatically set during the object initiliazation. Make any
	 * required modifications prior to sending the request.
	 */
	// @property (nonatomic, retain) id<FBGraphObject> graphObject;

	/** Starts a connection to the Facebook API.
	 * 
	 * This is used to start an API call to Facebook and call the block when the request completes with a success, error, or
	 * cancel.
	 * 
	 * @param handler The handler block to call when the request completes with a success, error, or cancel action. The handler
	 *           will be invoked on the main thread.
	 * @return */
	@Method(selector = "startWithCompletionHandler:")
	public native FBRequestConnection start (@Block FBRequestHandler handler);

	/** Creates a request representing a Graph API call to the "me" endpoint, using the active session.
	 * 
	 * Simplifies preparing a request to retrieve the user's identity.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * A successful Graph API call will return an <FBGraphUser> object representing the user's identity.
	 * 
	 * Note you may change the session property after construction if a session other than the active session is preferred. */
	@Method(selector = "requestForMe")
	public static native FBRequest requestForMe ();

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates a request representing a Graph API call to the "me/friends" endpoint using the active session.
	 * 
	 * @discussion Simplifies preparing a request to retrieve the user's friends.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * A successful Graph API call will return an array of <FBGraphUser> objects representing the user's friends.
	 */
	// + (FBRequest *)requestForMyFriends;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates a request representing a Graph API call to upload a photo to the app's album using the active session.
	 * 
	 * @discussion Simplifies preparing a request to post a photo.
	 * 
	 * To post a photo to a specific album, get the `FBRequest` returned from this method call, then modify the request parameters
	 * by adding the album ID to an "album" key.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param photo A `UIImage` for the photo to upload.
	 */
	// + (FBRequest *)requestForUploadPhoto:(UIImage *)photo;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates a request representing a status update.
	 * 
	 * @discussion Simplifies preparing a request to post a status update.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param message The message to post.
	 */
	// + (FBRequest *)requestForPostStatusUpdate:(NSString *)message;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates a request representing a status update.
	 * 
	 * @discussion Simplifies preparing a request to post a status update.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param message The message to post.
	 * 
	 * @param place The place to checkin with, or nil. Place may be an fbid or a graph object representing a place.
	 * 
	 * @param tags Array of friends to tag in the status update, each element may be an fbid or a graph object representing a user.
	 */
	// + (FBRequest *)requestForPostStatusUpdate:(NSString *)message
	// place:(id)place
	// tags:(id<NSFastEnumeration>)tags;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates a request representing a Graph API call to the "search" endpoint for a given location using the active
	 * session.
	 * 
	 * @discussion Simplifies preparing a request to search for places near a coordinate.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * A successful Graph API call will return an array of <FBGraphPlace> objects representing the nearby locations.
	 * 
	 * @param coordinate The search coordinates.
	 * 
	 * @param radius The search radius in meters.
	 * 
	 * @param limit The maxiumum number of results to return. It is possible to receive fewer than this because of the radius and
	 * because of server limits.
	 * 
	 * @param searchText The text to use in the query to narrow the set of places returned.
	 */
	// + (FBRequest *)requestForPlacesSearchAtCoordinate:(CLLocationCoordinate2D)coordinate
	// radiusInMeters:(NSInteger)radius
	// resultsLimit:(NSInteger)limit
	// searchText:(NSString*)searchText;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates a request representing the Graph API call to retrieve a Custom Audience "thirdy party ID" for the app's
	 * Facebook user. Callers will send this ID back to their own servers, collect up a set to create a Facebook Custom Audience
	 * with, and then use the resultant Custom Audience to target ads.
	 * 
	 * @param session The FBSession to use to establish the user's identity for users logged into Facebook through this app. If
	 * `nil`, then the activeSession is used.
	 * 
	 * @discussion This method will throw an exception if <[FBSettings defaultAppID]> is `nil`. The appID won't be nil when the
	 * pList includes the appID, or if it's explicitly set.
	 * 
	 * The JSON in the request's response will include an "custom_audience_third_party_id" key/value pair, with the value being the
	 * ID retrieved. This ID is an encrypted encoding of the Facebook user's ID and the invoking Facebook app ID. Multiple calls
	 * with the same user will return different IDs, thus these IDs cannot be used to correlate behavior across devices or
	 * applications, and are only meaningful when sent back to Facebook for creating Custom Audiences.
	 * 
	 * The ID retrieved represents the Facebook user identified in the following way: if the specified session (or activeSession if
	 * the specified session is `nil`) is open, the ID will represent the user associated with the activeSession; otherwise the ID
	 * will represent the user logged into the native Facebook app on the device. If there is no native Facebook app, no one is
	 * logged into it, or the user has opted out at the iOS level from ad tracking, then a `nil` ID will be returned.
	 * 
	 * This method returns `nil` if either the user has opted-out (via iOS) from Ad Tracking, the app itself has limited event
	 * usage via the `[FBAppEvents setLimitEventUsage]` flag, or a specific Facebook user cannot be identified.
	 */
	// + (FBRequest *)requestForCustomAudienceThirdPartyID:(FBSession *)session;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized request object that can be used to make a Graph API call for the active session.
	 * 
	 * @discussion This method simplifies the preparation of a Graph API call.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param graphPath The Graph API endpoint to use for the request, for example "me".
	 */
	// + (FBRequest *)requestForGraphPath:(NSString*)graphPath;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates request representing a DELETE to a object.
	 * 
	 * @discussion This method simplifies the preparation of a Graph API call.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param object This can be an NSString, NSNumber or NSDictionary representing an object to delete
	 */
	// + (FBRequest *)requestForDeleteObject:(id)object;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates a request representing a POST for a graph object.
	 * 
	 * @param graphPath The Graph API endpoint to use for the request, for example "me".
	 * 
	 * @param graphObject An object or open graph action to post.
	 */
	// + (FBRequest *)requestForPostWithGraphPath:(NSString*)graphPath
	// graphObject:(id<FBGraphObject>)graphObject;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized request object that can be used to make a Graph API call for the active session.
	 * 
	 * @discussion This method simplifies the preparation of a Graph API call.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param graphPath The Graph API endpoint to use for the request, for example "me".
	 * 
	 * @param parameters The parameters for the request. A value of nil sends only the automatically handled parameters, for
	 * example, the access token. The default is nil.
	 * 
	 * @param HTTPMethod The HTTP method to use for the request. A nil value implies a GET.
	 */
	// + (FBRequest *)requestWithGraphPath:(NSString*)graphPath
	// parameters:(NSDictionary*)parameters
	// HTTPMethod:(NSString*)HTTPMethod;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized request object that can be used to create a user owned Open Graph object for the
	 * active session.
	 * 
	 * @discussion This method simplifies the preparation of a Graph API call.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param object The Open Graph object to create. Some common expected fields include "title", "image", "url", etc.
	 */
	// + (FBRequest *)requestForPostOpenGraphObject:(id<FBOpenGraphObject>)object;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized request object that can be used to create a user owned Open Graph object for the
	 * active session.
	 * 
	 * @discussion This method simplifies the preparation of a Graph API call.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param type The fully-specified Open Graph object type (e.g., my_app_namespace:my_object_name)
	 * 
	 * @param title The title of the Open Graph object.
	 * 
	 * @param image The link to an image to be associated with the Open Graph object.
	 * 
	 * @param url The url to be associated with the Open Graph object.
	 * 
	 * @param description The description to be associated with the object.
	 * 
	 * @param objectProperties Any additional properties for the Open Graph object.
	 */
	// + (FBRequest *)requestForPostOpenGraphObjectWithType:(NSString *)type
	// title:(NSString *)title
	// image:(id)image
	// url:(id)url
	// description:(NSString *)description
	// objectProperties:(NSDictionary *)objectProperties;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized request object that can be used to update a user owned Open Graph object for the
	 * active session.
	 * 
	 * @discussion This method simplifies the preparation of a Graph API call.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param object The Open Graph object to update the existing object with.
	 */
	// + (FBRequest *)requestForUpdateOpenGraphObject:(id<FBOpenGraphObject>)object;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized request object that can be used to update a user owned Open Graph object for the
	 * active session.
	 * 
	 * @discussion This method simplifies the preparation of a Graph API call.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param objectId The id of the Open Graph object to update.
	 * 
	 * @param title The updated title of the Open Graph object.
	 * 
	 * @param image The updated link to an image to be associated with the Open Graph object.
	 * 
	 * @param url The updated url to be associated with the Open Graph object.
	 * 
	 * @param description The updated description of the Open Graph object.
	 * 
	 * @param objectProperties Any additional properties to update for the Open Graph object.
	 */
	// + (FBRequest *)requestForUpdateOpenGraphObjectWithId:(id)objectId
	// title:(NSString *)title
	// image:(id)image
	// url:(id)url
	// description:(NSString *)description
	// objectProperties:(NSDictionary *)objectProperties;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized request object that can be used to upload an image to create a staging resource.
	 * Staging resources allow you to post binary data such as images, in preparation for a post of an open graph object or action
	 * which references the image. The URI returned when uploading a staging resource may be passed as the image property for an
	 * open graph object or action.
	 * 
	 * @discussion This method simplifies the preparation of a Graph API call.
	 * 
	 * This method does not initialize an <FBRequestConnection> object. To initiate the API call first instantiate an
	 * <FBRequestConnection> object, add the request to this object, then call the `start` method on the connection instance.
	 * 
	 * @param image A `UIImage` for the image to upload.
	 */
	// + (FBRequest *)requestForUploadStagingResourceWithImage:(UIImage *)image;
}
