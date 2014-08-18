#import <Foundation/Foundation.h>


@interface LoginApi : NSObject <NSURLSessionDelegate>

extern NSString * const BASEURL;

- (void) login:(NSString*) username password:(NSString*) password;

- (void) request:(NSURL*) url body: (NSDictionary*) dictionary completionHandler:(void (^)(NSData *data, NSURLResponse *response, NSError *error))completionHandler;

- (id) init;
@end
