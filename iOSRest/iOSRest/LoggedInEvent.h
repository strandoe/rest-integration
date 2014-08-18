#import <Foundation/Foundation.h>


@interface LoggedInEvent : NSObject

@property (nonatomic, copy) NSString* token;

- (id) initWithToken: (NSString*) token;

@end