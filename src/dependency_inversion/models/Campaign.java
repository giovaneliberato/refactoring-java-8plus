package dependency_inversion.models;

import java.util.List;

public class Campaign {

    public static CampaignBuilder builder() {
        return new CampaignBuilder();
    }

    public static class CampaignBuilder {
        public CampaignBuilder pushNotificationIds(List<String> pushNotificationIds) {
            return this;
        }

        public CampaignBuilder message(Message message) {
            return null;
        }

        public Campaign build() {
            return new Campaign();
        }
    }
}
