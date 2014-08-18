#import <Foundation/Foundation.h>
#import "LoginApi.h"
#import "LoggedInEvent.h"
#import "LoginEvent.h"
#import "Tolo.h"

@interface LoginApi ()

@end

@implementation LoginApi

NSString * const BASEURL = @"https://mobil2014.herokuapp.com/api";

- (id) init {
    if (self = [super init]) {
        REGISTER();
    }
    return self;
}

SUBSCRIBE(LoginEvent) {
    [self login:event.username password:event.password];
}

- (void) login:(NSString *)username password:(NSString *)password {
    
    NSURL *url = [NSURL URLWithString:[NSString stringWithFormat:@"%@/%@", BASEURL, @"oauth/token"]];
    
    NSDictionary *mapData = [[NSDictionary alloc] initWithObjectsAndKeys: @"password", @"grant_type",
                             @"REST-INTEGRATION-EXAMPLE-APP", @"client_id",
                             @"supersecret123", @"client_secret",
                             username, @"username",
                             password, @"password",
                             nil];

    [self request:url body:mapData completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) {
        if (error != nil) {
            NSLog(@"Request failed with error: %@", error);
        }
        NSDictionary *dictionary = [NSJSONSerialization JSONObjectWithData:data options:0 error:nil];
        LoggedInEvent* event = [[LoggedInEvent alloc] initWithToken:[dictionary valueForKey:@"access_token"]];
        PUBLISH(event);
    }];
    
}

- (void) request: (NSURL*) url body:(NSDictionary *)dictionary completionHandler:(void (^)(NSData *, NSURLResponse *, NSError *))completionHandler {
    NSError *error;
    
    NSURLSessionConfiguration *configuration = [NSURLSessionConfiguration defaultSessionConfiguration];
    NSURLSession *session = [NSURLSession sessionWithConfiguration:configuration delegate:self delegateQueue:nil];
    
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:url
                                                           cachePolicy:NSURLRequestUseProtocolCachePolicy
                                                       timeoutInterval:60.0];
    
    [request addValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    [request addValue:@"application/json" forHTTPHeaderField:@"Accept"];
    
    [request setHTTPMethod:@"POST"];
        NSData *postData = [NSJSONSerialization dataWithJSONObject:dictionary options:0 error:&error];
    [request setHTTPBody:postData];
    
    
    NSURLSessionDataTask *postDataTask = [session dataTaskWithRequest:request completionHandler: completionHandler];
    [postDataTask resume];
}

@end