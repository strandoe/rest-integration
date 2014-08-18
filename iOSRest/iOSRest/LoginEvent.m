#import <Foundation/Foundation.h>
#import "LoginEvent.h"

@interface LoginEvent ()

@end

@implementation LoginEvent

-(id) initWithUsername:(NSString *)username password:(NSString *)password {
    if (self = [super init]) {
        self.username = username;
        self.password = password;
    }
    return self;
}

@end