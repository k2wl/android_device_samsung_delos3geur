From 09cbc99e92b2e7e376ed4463730f94a5c5dc7969 Mon Sep 17 00:00:00 2001
From: k2wl <k2wl@github.com>
Date: Fri, 20 Jun 2014 08:30:22 +0530
Subject: [PATCH] ril java patch to get proper identification.

Change-Id: Id221590300848f74b469917ad02fd95192edcd99
---
 src/java/com/android/internal/telephony/RIL.java | 6 +++---
 1 file changed, 3 insertions(+), 3 deletions(-)

diff --git a/src/java/com/android/internal/telephony/RIL.java b/src/java/com/android/internal/telephony/RIL.java
index c20e4bd..f3feb26 100644
--- a/src/java/com/android/internal/telephony/RIL.java
+++ b/src/java/com/android/internal/telephony/RIL.java
@@ -65,7 +65,7 @@ import com.android.internal.telephony.uicc.IccCardApplicationStatus;
 import com.android.internal.telephony.uicc.IccCardStatus;
 import com.android.internal.telephony.uicc.IccIoResult;
 import com.android.internal.telephony.uicc.IccRefreshResponse;
-import com.android.internal.telephony.uicc.IccUtils;
+import com.android.internal.telephony.IccUtils;
 import com.android.internal.telephony.cdma.CdmaCallWaitingNotification;
 import com.android.internal.telephony.cdma.CdmaInformationRecords;
 import com.android.internal.telephony.cdma.CdmaSmsBroadcastConfigInfo;
@@ -3591,6 +3591,7 @@ public class RIL extends BaseCommands implements CommandsInterface {
     responseCallList(Parcel p) {
         int num;
         int voiceSettings;
+       boolean isVideo;
         ArrayList<DriverCall> response;
         DriverCall dc;
 
@@ -3613,8 +3614,7 @@ public class RIL extends BaseCommands implements CommandsInterface {
             dc.als = p.readInt();
             voiceSettings = p.readInt();
             dc.isVoice = (0 == voiceSettings) ? false : true;
-            if(samsungDriverCall)
-                 p.readInt();
+            isVideo = (0 != p.readInt());
             dc.isVoicePrivacy = (0 != p.readInt());
             dc.number = p.readString();
             int np = p.readInt();
-- 
1.9.1

