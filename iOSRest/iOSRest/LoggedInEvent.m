#import <Foundation/Foundation.h>
#import "LoggedInEvent.h"

@interface LoggedInEvent ()

@end

@implementation LoggedInEvent

- (id) initWithToken:(NSString *)token {
    self = [super init];
    if (self) {
        self.token = token;
    }
    return self;
}

@end