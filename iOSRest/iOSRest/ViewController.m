#import "ViewController.h"
#import "Tolo.h"
#import "LoginEvent.h"
#import "LoggedInEvent.h"

@interface ViewController ()

@end

@implementation ViewController
            
- (void)viewDidLoad {
    [super viewDidLoad];
    REGISTER();
    LoginEvent* event = [[LoginEvent alloc] initWithUsername:@"username" password:@"password"];
    PUBLISH(event);
}

SUBSCRIBE(LoggedInEvent) {
    NSLog(@"Logged in with token %@", event.token);
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
