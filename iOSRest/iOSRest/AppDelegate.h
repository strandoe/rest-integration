//
//  AppDelegate.h
//  iOSRest
//
//  Created by Øystein Strand on 18.08.14.
//  Copyright (c) 2014 Øystein Strand. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "LoginApi.h"

@interface AppDelegate : UIResponder <UIApplicationDelegate>

@property (strong, nonatomic) UIWindow *window;

@property (nonatomic, retain) LoginApi *loginApi;

@end

