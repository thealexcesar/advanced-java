package netflix.service;

import netflix.domain.SubscriptionPlan;
import netflix.domain.User;

public class SubscriptionService {
    public void changePlan(User user, SubscriptionPlan newPlan) {
        user.setPlan(newPlan);
    }
}
