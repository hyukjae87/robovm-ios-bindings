
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/** The FBGraphObject protocol is the base protocol which enables typed access to graph objects and open graph objects. Inherit
 * from this protocol or a sub-protocol in order to introduce custom types for typed access to Facebook objects.
 * 
 * The `FBGraphObject` protocol is the core type used by the Facebook SDK for iOS to represent objects in the Facebook Social
 * Graph and the Facebook Open Graph (OG). The `FBGraphObject` class implements useful default functionality, but is rarely used
 * directly by applications. The `FBGraphObject` protocol, in contrast is the base protocol for all graph object access via the
 * SDK.
 * 
 * Goals of the FBGraphObject types:
 * <ul>
 * <li>Lightweight/maintainable/robust</li>
 * <li>Extensible and resilient to change, both by Facebook and third party (OG)</li>
 * <li>Simple and natural extension to Objective-C</li>
 * </ul>
 * 
 * The FBGraphObject at its core is a duck typed (if it walks/swims/quacks... its a duck) model which supports an optional static
 * facade. Duck-typing achieves the flexibility necessary for Social Graph and OG uses, and the static facade increases
 * discoverability, maintainability, robustness and simplicity. The following excerpt from the PlacePickerSample shows a simple
 * use of the a facade protocol `FBGraphPlace` by an application:
 * 
 * <pre>
 *  &dash; (void)placePickerViewControllerSelectionDidChange:(FBPlacePickerViewController *)placePicker
 *  {
 *  id&#060;FBGraphPlace&#062; place = placePicker.selection;
 * 
 *  // we'll use logging to show the simple typed property access to place and location info
 *  NSLog(@"place=%@, city=%@, state=%@, lat long=%@ %@",
 *  place.name,
 *  place.location.city,
 *  place.location.state,
 *  place.location.latitude,
 *  place.location.longitude);
 *  }
 * </pre>
 * 
 * Note that in this example, access to common place information is available through typed property syntax. But if at some point
 * places in the Social Graph supported additional fields "foo" and "bar", not reflected in the `FBGraphPlace` protocol, the
 * application could still access the values like so:
 * 
 * <pre>
 *  NSString *foo = [place objectForKey:@"foo"]; // perhaps located at the ... in the preceding example
 *  NSNumber *bar = [place objectForKey:@"bar"]; // extensibility applies to Social and Open graph uses
 * </pre>
 * 
 * In addition to untyped access, applications and future revisions of the SDK may add facade protocols by declaring a protocol
 * inheriting the `FBGraphObject` protocol, like so:
 * 
 * <pre>
 *  &#064;protocol MyGraphThing&#060;FBGraphObject&#062;
 *  &#064;property (copy, nonatomic) NSString *id;
 *  &#064;property (copy, nonatomic) NSString *name;
 *  &#064;end
 * </pre>
 * 
 * Important: facade implementations are inferred by graph objects returned by the methods of the SDK. This means that no explicit
 * implementation is required by application or SDK code. Any `FBGraphObject` instance may be cast to any `FBGraphObject` facade
 * protocol, and accessed via properties. If a field is not present for a given facade property, the property will return nil.
 * 
 * The following layer diagram depicts some of the concepts discussed thus far:
 * 
 * <pre>
 * -------------* *------------* *-------------**--------------------------*
 *  Facade --> | FBGraphUser | |FBGraphPlace| | MyGraphThing|| MyGraphPersonExtentension| ...
 * -------------* *------------* *-------------**--------------------------*
 * ------------------------------------* *--------------------------------------*
 *  Transparent impl --> |     FBGraphObject (instances)      | |      CustomClass&#060;FBGraphObject&#062;      |
 * ------------------------------------* *--------------------------------------*
 * -------------------**------------------------* *-----------------------------*
 *  Apparent impl --> |NSMutableDictionary||FBGraphObject (protocol)| |FBGraphObject (class methods)|
 * -------------------**------------------------* *-----------------------------*
 * </pre>
 * 
 * The *Facade* layer is meant for typed access to graph objects. The *Transparent impl* layer (more specifically, the instance
 * capabilities of FBGraphObject) are used by the SDK and app logic internally, but are not part of the public interface between
 * application and SDK. The *Apparent impl* layer represents the lower-level "duck-typed" use of graph objects.
 * 
 * Implementation note: the SDK returns `NSMutableDictionary` derived instances with types declared like one of the following:
 * 
 * <pre>
 *  NSMutableDictionary&#060;FBGraphObject&#062; *obj;     // no facade specified (still castable by app)
 *  NSMutableDictionary&#060;FBGraphPlace&#062; *person;   // facade specified when possible
 * </pre>
 * 
 * However, when passing a graph object to the SDK, `NSMutableDictionary` is not assumed; only the FBGraphObject protocol is
 * assumed, like so:
 * 
 * <pre>
 * id&lt;FBGraphObject&gt; anyGraphObj;
 * </pre>
 * 
 * As such, the methods declared on the `FBGraphObject` protocol represent the methods used by the SDK to consume graph objects.
 * While the `FBGraphObject` class implements the full `NSMutableDictionary` and KVC interfaces, these are not consumed directly
 * by the SDK, and are optional for custom implementations. */
@NativeClass
public class FBGraphObject extends NSMutableDictionary<NSObject, NSObject> {

	// /*!
	// @method
	// @abstract
	// Returns the number of properties on this `FBGraphObject`.
	// */
	// - (NSUInteger)count;

	/** Returns a property on this {@link #FBGraphObject}.
	 * 
	 * @param key name of the property to return */
	@Method(selector = "objectForKey:")
	public native NSObject getProperty (String key);

	// /*!
	// @method
	// @abstract
	// Returns an enumerator of the property names on this `FBGraphObject`.
	// */
	// - (NSEnumerator *)keyEnumerator;
	// /*!
	// @method
	// @abstract
	// Removes a property on this `FBGraphObject`.
	//
	// @param aKey name of the property to remove
	// */
	// - (void)removeObjectForKey:(id)aKey;
	// /*!
	// @method
	// @abstract
	// Sets the value of a property on this `FBGraphObject`.
	//
	// @param anObject the new value of the property
	// @param aKey name of the property to set
	// */
	// - (void)setObject:(id)anObject forKey:(id)aKey;
	//
	// @optional
	//
	// /*!
	// @abstract
	// This property signifies that the current graph object is provisioned for POST (as a definition
	// for a new or updated graph object), and should be posted AS-IS in its JSON encoded form, whereas
	// some graph objects (usually those embedded in other graph objects as references to existing objects)
	// may only have their "id" or "url" posted.
	// */
	// @property (nonatomic, assign) BOOL provisionedForPost;

	//
	// /*!
	// @class
	//
	// @abstract
	// Static class with helpers for use with graph objects
	//
	// @discussion
	// The public interface of this class is useful for creating objects that have the same graph characteristics
	// of those returned by methods of the SDK. This class also represents the internal implementation of the
	// `FBGraphObject` protocol, used by the Facebook SDK. Application code should not use the `FBGraphObject` class to
	// access instances and instance members, favoring the protocol.
	// */
	// @interface FBGraphObject : NSMutableDictionary<FBGraphObject>
	//
	// /*!
	// @method
	// @abstract
	// Used to create a graph object, usually for use in posting a new graph object or action.
	// */
	// + (NSMutableDictionary<FBGraphObject>*)graphObject;
	//
	/** Used to wrap an existing dictionary with a FBGraphObject facade.
	 * 
	 * Normally you will not need to call this method, as the Facebook SDK already "FBGraphObject-ifys" json objects fetch via
	 * `FBRequest` and `FBRequestConnection`. However, you may have other reasons to create json objects in your application, which
	 * you would like to treat as a graph object. The pattern for doing this is that you pass the root node of the json to this
	 * method, to retrieve a wrapper. From this point, if you traverse the graph, any other objects deeper in the hierarchy will be
	 * wrapped as `FBGraphObject`'s in a lazy fashion.
	 * 
	 * This method is designed to avoid unnecessary memory allocations, and object copying. Due to this, the method does not copy
	 * the source object if it can be avoided, but rather wraps and uses it as is. The returned object derives callers shoudl use
	 * the returned object after calls to this method, rather than continue to call methods on the original object.
	 * @param jsonDictionary the dictionary representing the underlying object to wrap. */
	@Method(selector = "graphObjectWrappingDictionary:")
	public static native FBGraphObject createGraphObject (NSDictionary<?, ?> jsonDictionary);

	/** Used to create a graph object that's provisioned for POST, usually for use in posting a new Open Graph Action. */
	@Method(selector = "openGraphActionForPost")
	public static native FBOpenGraphAction createGraphAction ();

	/** Used to create a graph object that's provisioned for POST, usually for use in posting a new Open Graph object.
	 * @param type the object type name, in the form namespace:typename
	 * @param title a title for the object
	 * @param image the image property for the object
	 * @param url the url property for the object
	 * @param description the description for the object */
	@Method(selector = "openGraphObjectForPostWithType:title:image:url:description:")
	public static native FBOpenGraphObject createGraphObject (String type, String title, NSObject image, NSURL url,
		String description);
	//
	// /*!
	// @method
	// @abstract
	// Used to compare two `FBGraphObject`s to determine if represent the same object. We do not overload
	// the concept of equality as there are various types of equality that may be important for an `FBGraphObject`
	// (for instance, two different `FBGraphObject`s could represent the same object, but contain different
	// subsets of fields).
	//
	// @param anObject an `FBGraphObject` to test
	//
	// @param anotherObject the `FBGraphObject` to compare it against
	// */
	// + (BOOL)isGraphObjectID:(id<FBGraphObject>)anObject sameAs:(id<FBGraphObject>)anotherObject;
}
