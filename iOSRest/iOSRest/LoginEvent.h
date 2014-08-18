#import <Foundation/Foundation.h>


@interface LoginEvent : NSObject

@property (nonatomic, copy) NSString* username;
@property (nonatomic, copy) NSString* password;

- (id) initWithUsername: (NSString*) username password: (NSString*) password;

@end