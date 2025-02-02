//
//  MPNativeAdData.h
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>

@class MPNativeAd;

@interface MPNativeAdData : NSObject

@property (nonatomic, copy) NSString *adUnitID;
@property (nonatomic, retain) MPNativeAd *ad;
@property (nonatomic, assign) Class renderingClass;

@end
