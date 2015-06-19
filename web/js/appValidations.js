function checkName(input){
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    if (/\d/.test(input.value)){
        alert('Contains a number');
        input.value = input.value='';
        blnValid = false;
    } 
    return true;
}
function DateOfBirth(input){
    if (input.value ===''){
        alert('Date field is empty');
        blnValid = false;
    }else{
        blnValid = true;
    }
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    return blnValid;
}
function checkID(input){
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    if(/\d/.test(input.value) && input.value.length == 13){
        blnValid = true;
    }else{
        alert('Check your ID number');
        input.value = input.value='';
        blnValid = false;
    }
    return blnValid;
}
function checIfNo(input){
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    if(/\d/.test(input.value) && input.value > 0 && input.value <= 12){
        blnValid = true;
    }else{
        alert('Check highest grade passed');
        input.value = input.value='';
        blnValid = false;
    }
    return blnValid;
}
function checIfNo2(input){
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    if (/^[0-9]*$/.test(input.value)== false){
        alert('Check examination number');
        input.value = input.value='';
        blnValid = true;
    }else{
        
        blnValid = false;
    }
    return blnValid;
}
function checIfNo3(input){
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    if(/^[0-9]*$/.test(input.value)== false){
        alert('Check Post Code');
        input.value = input.value='';
        blnValid = true;
    }else{
        blnValid = false;
    }
    return blnValid;
}
function checIfNo4(input){
   if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    if(/^[0-9]*$/.test(input.value) && input.value.length == 10){
        blnValid = true;
    }else{
        alert('Check Cell Phone number');
        input.value = input.value='';
        blnValid = false;
    }
    
    return blnValid;
}
function checkName2(input){
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    if (/\d/.test(input.value)){
        alert('School name contains numbers');
        input.value = input.value='';
        blnValid = false;
    } 
    return blnValid;
}
function isEmptyFi(input){
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    return blnValid;
}
function validateEmail(input) {
    if (input.value ===''){
         alert('Field is empty');
         blnValid = false;
    }else{
        blnValid = true;
    }
    if(/\S+@\S+\.\S+/.test(input.value)){
        blnValid = true;
    }else{
        alert('Email in-valid');
        input.value = input.value='';
        blnValid = false;
    }
    return blnValid;
}
function courseSelect(){
        var selectedCourseIndex = document.forms[0].course.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a course')
        }
    return selectedCourseIndex;
}
function titleSelect(){
        var selectedCourseIndex = document.forms[0].title.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a title')
        }
    return selectedCourseIndex;
}
function marriageSelect(){
        var selectedCourseIndex = document.forms[0].marriage.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a Marital Status')
        }
    return selectedCourseIndex;
}
function homeLingoSelect(){
        var selectedCourseIndex = document.forms[0].homeLingo.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a Home language')
        }
    return selectedCourseIndex;
}
function popGroupSelect(){
        var selectedCourseIndex = document.forms[0].popGroup.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a Population group')
        }
    return selectedCourseIndex;
}
function churchSelect(){
        var selectedCourseIndex = document.forms[0].church.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a Church Affiliation')
        }
    return selectedCourseIndex;
}
function citizenSelect(){
        var selectedCourseIndex = document.forms[0].citizen.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a Citizenship')
        }
    return selectedCourseIndex;
}
function hearOfTUTSelect(){
        var selectedCourseIndex = document.forms[0].hearOfTUT.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select Where did you hear about TUT')
        }
    return selectedCourseIndex;
}
function citizTyoeSelect(){
        var selectedCourseIndex = document.forms[0].citizTyoe.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a Citizenship Type')
        }
    return selectedCourseIndex;
}
function previousActivitySelect(){
        var selectedCourseIndex = document.forms[0].previousActivity.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a What is your present activity before you started studies')
        }
    return selectedCourseIndex;
}
function matricCertTypeSelect(){
        var selectedCourseIndex = document.forms[0].matricCertType.selectedIndex;
        if (selectedCourseIndex == 0){
            alert('Please select a Type of leaving certificate')
        }
    return selectedCourseIndex;
}
function genderDet(){
    if (document.forms[0].gender[0].checked == true){
        genderType = 'Male';
    }else if(document.forms[0].gender[1].checked == true){
        genderType = 'Female';
    }
    return genderType;
}
function exemptionDet(){
    if (document.forms[0].exemption[0].checked == true){
        exemptionStat = 'Yes';
    }else if(document.forms[0].exemption[1].checked == true){
        exemptionStat = 'No';
    }
    return exemptionStat;
}
function accomodationDet(){
    if (document.forms[0].accomodation[0].checked == true){
        accomodationStat = 'Yes';
    }else if(document.forms[0].accomodation[1].checked == true){
        accomodationStat = 'No';
    }
    return accomodationStat;
}
function financeAssistDet(){
    if (document.forms[0].financeAssist[0].checked == true){
        financeAssistStat = 'Yes';
    }else if(document.forms[0].financeAssist[1].checked == true){
        financeAssistStat = 'No';
    }
    return financeAssistStat;
}
function emmplyedDet(){
    if (document.forms[0].emmplyed[0].checked == true){
        emmplyedStat = 'Yes';
    }else if (document.forms[0].emmplyed[1].checked == true){
        emmplyedStat = 'No';
    }
    return emmplyedStat;
}
function returnCourse(){
	switch(courseSelect()){
        case 1:
			course = 'N DIP - Multimedia(NDIU04)';
		break;
		case 2:
			course = 'N DIP - Web And Application Development(NDI04)';
		break;
		case 3:
			course = 'N DIP - Web And Application Development(NDIW00)';
		break;
		case 4:
			course = 'B TECH - Multimedia(BTIU05)';
		break;
		case 5:
			course = 'B TECH - Web And Application Development(BTIW05)';
		break;
		case 6:
			course = 'NATIONAL CERTIFICATE - WEBMASTER(NCWE03)';
		break;
    }
	return course;
}
	function returnTitle(){
	switch(titleSelect()){
		case 1:
		title = 'ADVOCATE';
		break;
		case 2:
		title = 'BRIG';
		break;
		case 3:
		title = 'COMP';
		break;
		case 4:
		title = 'CORP';
		break;
		case 5:
		title = 'CPT';
		break;
		case 6:
		title = 'DOCTOR';
		break;
		case 7:
		title = 'DS';
		break;
		case 8:
		title = 'ME';
		break;
		case 9:
		title = 'MEJ';
		break;
		case 10:
		title = 'MENEER';
		break;
		case 11:
		title = 'MEV';
		break;
		case 12:
		title = 'MISS';
		break;
		case 13:
		title = 'MR';
		break;
		case 14:
		title = 'MRS';
		break;
		case 15:
		title = 'MS';
		break;
		case 16:
		title = 'PROFESSOR';
		break;
		case 17:
		title = 'RC';
		break;
		case 18:
		title = 'REVEREND';
		break;
	}
	return title;
	}
	function returnMarriage(){
		switch(marriageSelect()){
		case 1:
		marriage = 'Single';
		break;
		case 2:
		marriage = 'Married';
		break;
		case 3:
		marriage = 'Divorced';
		break;
		case 4:
		marriage = 'Widow/er';
		break;
		}
		return marriage;
	}
	function returnHome(){
		switch(homeLingoSelect()){
		case 1:
		homeL = 'AFRIKAANS';
		break;
		case 2:
		homeL = 'AFRIKAANS/ENGLISH';
		break;
		case 3:
		homeL = 'CHICHEWA';
		break;
		case 4:
		homeL = 'CZECH';
		break;
		case 5:
		homeL = 'DAMARA';
		break;
		case 6:
		homeL = 'DUTCH';
		break;
		case 7:
		homeL = 'ENGLISH';
		break;
		case 8:
		homeL = 'FLEMISH';
		break;
		case 9:
		homeL = 'FRENCH';
		break;
		case 10:
		homeL = 'GERMAN';
		break;
		case 11:
		homeL = 'GREEK';
		break;
		case 12:
		homeL = 'HUNGARIAN';
		break;
		case 13:
		homeL = 'ITALIAN';
		break;
		case 14:
		homeL = 'NDEBELE';
		break;
		case 15:
		homeL = 'NDONGA';
		break;
		case 16:
		homeL = 'NORTH SOTHO';
		break;
		case 17:
		homeL = 'OTHER';
		break;
		case 18:
		homeL = 'OTHER BLACK LANGUAGE';
		break;
		case 19:
		homeL = 'OTHER EUROPEAN LANGUAGE';
		break;
		case 20:
		homeL = 'OWAMBO';
		break;
		case 21:
		homeL = 'POLISH';
		break;
		case 22:
		homeL = 'PORTUGESE';
		break;
		case 23:
		homeL = 'SETSWANA';
		break;
		case 24:
		homeL = 'SHIBUNDU';
		break;
		case 25:
		homeL = 'SHONA';
		break;
		case 26:
		homeL = 'SLOVAC';
		break;
		case 27:
		homeL = 'SOTHO(SOUTH)';
		break;
		case 28:
		homeL = 'SOUTHERN NDEBELE';
		break;
		case 29:
		homeL = 'SPANISH';
		break;
		case 30:
		homeL = 'SWAZI';
		break;
		case 31:
		homeL = 'SWISS';
		break;
		case 32:
		homeL = 'TSONGA';
		break;
		case 33:
		homeL = 'TSONGA/SJANGAAN';
		break;
		case 34:
		homeL = 'UNKNOWN';
		break;
		case 35:
		homeL = 'VENDA';
		break;
		case 36:
		homeL = 'XHOSA';
		break;
		case 37:
		homeL = 'ZULU';
		break;
	}
	return homeL;
	}
	function returnPopGroup(){
		switch(popGroupSelect()){
		case 1:
		popGroup = 'AFRICAN';
		break;
		case 2:
		popGroup = 'COLOURED';
		break;
		case 3:
		popGroup = 'INDIAN';
		break;
		case 4:
		popGroup = 'NDEBELE';
		break;
		case 5:
		popGroup = 'NORTH SOTHO';
		break;
		case 6:
		popGroup = 'PEDI';
		break;
		case 7:
		popGroup = 'SOUTH SOTHO';
		break;
		case 8:
		popGroup = 'SWATI';
		break;
		case 9:
		popGroup = 'TSONGA';
		break;
		case 10:
		popGroup = 'TSWANA';
		break;
		case 11:
		popGroup = 'VENDA';
		break;
		case 12:
		popGroup = 'WHITE';
		break;
		case 13:
		popGroup = 'XHOSA';
		break;
		case 14:
		popGroup = 'ZULU';
		break;
	}
	return popGroup;
	}
	function returnChurch(){
		switch(churchSelect()){
		case 1:
		church = 'AFM';
		break;
		case 2:
		church = 'AFRICAN CATHOLIC CHURCH';
		break;
		case 3:
		church = 'AFRICAN GAZA CHURCH';
		break;
		case 4:
		church = 'AFRIKAANSE PROTESTANT';
		break;
		case 5:
		church = 'AME';
		break;
		case 6:
		church = 'ANGLICAN';
		break;
		case 7:
		church = 'APOSTOLIC CATHOLIC';
		break;
		case 8:
		church = 'ASSEMBLIES OF GOD';
		break;
		case 9:
		church = 'BAPTIST';
		break;
		case 10:
		church = 'CHARITAMIC CHRISTIAN';
		break;
		case 11:
		church = 'CHRISTIAN REVIVAL CENTRE';
		break;
		case 12:
		church = 'CHURCH OF CHRIST';
		break;
		case 13:
		church = 'CHURCH OF ENGLAND';
		break;
		case 14:
		church = 'DUTCH REFORMED';
		break;
		case 15:
		church = 'EVANGELICAL REFORMED';
		break;
		case 16:
		church = 'FAITH MISSION';
		break;
		case 17:
		church = 'FULL GOSPEL';
		break;
		case 18:
		church = 'GREEK ORTHODOX';
		break;
		case 19:
		church = 'HINDU';
		break;
		case 20:
		church = 'IPC';
		break;
		case 21:
		church = "JEHOVA'S WITNESS";
		break;
		case 22:
		church = 'JEWISH';
		break;
		case 23:
		church = 'LUTHERAN';
		break;
		case 24:
		church = 'MALOMBO';
		break;
		case 25:
		church = 'METHODIST';
		break;
		case 26:
		church = 'MUSLIM';
		break;
		case 27:
		church = 'NAZARENE';
		break;
		case 28:
		church = 'NEW APOSTOLIC';
		break;
		case 29:
		church = 'NH CHURCH';
		break;
		case 30:
		church = 'NONE';
		break;
		case 31:
		church = 'NOT PREPARD TO DIVULGE';
		break;
		case 32:
		church = 'OLD APOSTOLIC';
		break;
		case 33:
		church = 'OTHER';
		break;
		case 34:
		church = 'OTHER PROTESTANT CHURCHES';
		break;
		case 35:
		church = 'PENTECOSTAL PROTESTANT';
		break;
		case 36:
		church = 'PRESBYERIAN';
		break;
		case 37:
		church = 'REFORMED';
		break;
		case 38:
		church = 'REFORMED CHURCHES OF SA';
		break;
		case 39:
		church = 'RHEMA';
		break;
		case 40:
		church = 'ROMAN CATHOLIC';
		break;
		case 41:
		church = 'SCIENTOLOGY';
		break;
		case 42:
		church = 'SEVENTH DAY ADVENTIST';
		break;
		case 43:
		church = 'ST JOHNS CATHOLIC';
		break;
		case 44:
		church = 'ST PAULS FAITH MISSION';
		break;
		case 45:
		church = 'ST PETERS';
		break;
		case 46:
		church = 'UNKNOWN';
		break;
		case 47:
		church = 'ZION APOSTOLIC CHURCH';
		break;
		case 48:
		church = 'ZION CHRISTIAN CHURCH(ZCC)';
		break;
		case 49:
		church = 'ZIONIST CHURCH OF AFRICA';
		break;
	}
	return church;
	}
	function returnCitizen(){
		switch(citizenSelect()){
		case 1:
		citizenship = 'AUSTRALIA';
		break;
		case 2:
		citizenship = 'BAHAMAS';
		break;
		case 3:
		citizenship = 'BRAZIL';
		break;
		case 4:
		citizenship = 'CENTRAL AFRICAN REPUBLIC';
		break;
		case 5:
		citizenship = 'CHAD';
		break;
		case 6:
		citizenship = 'COLOMBIA';
		break;
		case 7:
		citizenship = 'EGPYT';
		break;
		case 8:
		citizenship = 'ETHIOPIA';
		break;
		case 9:
		citizenship = 'FINLAND';
		break;
		case 10:
		citizenship = 'GERMANY';
		break;
		case 11:
		citizenship = 'GHANA';
		break;
		case 12:
		citizenship = 'ICELAND';
		break;
		case 13:
		citizenship = 'INDONESIA';
		break;
		case 14:
		citizenship = 'JAMAICA';
		break;
		case 15:
		citizenship = 'KENYA';
		break;
		case 16:
		citizenship = 'MOZAMBIQUE';
		break;
		case 17:
		citizenship = 'NIGERIA';
		break;
		case 18:
		citizenship = 'OTHER AFRICAN';
		break;
		case 19:
		citizenship = 'SOUTH AFRICAN';
		break;
		case 20:
		citizenship = prompt("Please enter the name of your citizenship");
		break;
	}
	return citizenship;
	}
	function returnHearOFTut(){
		switch(hearOfTUTSelect()){
		case 1:
		news = 'A DU PLESIS';
		break;
		case 2:
		news = 'CAREER EXHIBITION';
		break;
		case 3:
		news = 'CURRENT STUDENT';
		break;
		case 4:
		news = 'EDUFAC RECRUITMENT';
		break;
		case 5:
		news = 'FAMILY MEMBER';
		break;
		case 6:
		news = 'FORMER STUDENT';
		break;
		case 7:
		news = 'FRIEND';
		break;
		case 8:
		news = 'GOLF ACADEMY';
		break;
		case 9:
		news = 'GUIDANCE COUNSELLOR/TEACHER';
		break;
		case 10:
		news = 'GUIDANCE TEACHER/COUNSELLOR';
		break;
		case 11:
		news = 'INFORMATION';
		break;
		case 12:
		news = 'INTERNET';
		break;
		case 13:
		news = 'JASPER VAN DER WESTHUIZEN';
		break;
		case 14:
		news = 'NEWSPAPERS';
		break;
		case 15:
		news = 'ONDERWYSERSOPLEIDING';
		break;
		case 16:
		news = 'OPEN DAY';
		break;
		case 17:
		news = 'OPEN LEARNING';
		break;
		case 18:
		news = 'RADIO PROGRAM';
		break;
		case 19:
		news = 'RECRUITMENT';
		break;
		case 20:
		news = 'SCHOOL VISIT';
		break;
		case 21:
		news = 'SOCIAL MEDIA';
		break;
		case 22:
		news = 'WESTGATE';
		break;
		case 23:
		news = 'WORD OF MOUTH';
		break;
	}
	return news;
	}
	function returnCitizenType(){	    
	switch(citizTyoeSelect()){
		case 1:
		citizenType = 'Diplomatic';
		break;
		case 2:
		citizenType = 'RSA';
		break;
		case 3:
		citizenType = 'Refugee';
		break;
		case 4:
		citizenType = 'With Permanent Resident Permit';
		break;
		case 5:
		citizenType = 'Without Permanent Resident Permit';
		break;
	}
	return citizenType;
	}
	function returnPreviouAct(){
		switch(previousActivitySelect()){
		case 1:
		pvrAct = 'COLLEGE OF NURSING STUDENT';
		break;
		case 2:
		pvrAct = 'GRADE 12';
		break;
		case 3:
		pvrAct = 'LABOUR FORCE';
		break;
		case 4:
		pvrAct = 'NATIONAL SERVICE';
		break;
		case 5:
		pvrAct = 'OTHER';
		break;
		case 6:
		pvrAct = "TEACHER'S TRAINING COLLEGE";
		break;
		case 7:
		pvrAct = 'TECHNICAL COLLEGE STUDENT';
		break;
		case 8:
		pvrAct = 'TECHNIKON STUDENT';
		break;
		case 9:
		pvrAct = 'UNIVERSITY STUDENT';
		break;
	}
	return pvrAct;
	}
	function returnMatricType(){
		switch(matricCertTypeSelect()){
		case 1:
		matricType = 'Cert of Complete Exemption';
		break;
		case 2:
		matricType = 'Discretionary Provision';
		break;
		case 3:
		matricType = 'Foreigners Exemption';
		break;
		case 4:
		matricType = 'Immigrants Exemption';
		break;
		case 5:
		matricType = 'Incomplete';
		break;
		case 6:
		matricType = 'Mature Age Exemption';
		break;
		case 7:
		matricType = 'NCV L4';
		break;
		case 8:
		matricType = 'NCV L4 Admission Bachelor';
		break;
		case 9:
		matricType = 'NCV L4 Admission Certificate';
		break;
		case 10:
		matricType = 'NCV L4 Admission Diploma';
		break;
		case 11:
		matricType = 'NCV L4 Admission Failed';
		break;
		case 12:
		matricType = 'NCV Level 3';
		break;
		case 13:
		matricType = 'NSC Admission Bachelor';
		break;
		case 14:
		matricType = 'NSC Admission Certificate';
		break;
		case 15:
		matricType = 'NSC Admission Diploma';
		break;
		case 16:
		matricType = 'NSC Admission None';
		break
		case 17:
		matricType = 'NSC Grade 12';
		break;
		case 18:
		matricType = 'NTC3/N3/NSC';
		break;
		case 19:
		matricType = 'Ordinary Conditional Exemption';
		break;
		case 20:
		matricType = 'Other';
		break;
		case 21:
		matricType = 'Other Senior Certificates';
		break;
		case 22:
		matricType = 'Standard 10 Practical';
		break;
	}
	return matricType;
	}
function determineIfValid(){
	surname = document.getElementById("surname").value;
	names = document.getElementById("names").value;
	initials  = document.getElementById("initials").value;
	nickName = document.getElementById("nickName").value;
	dateOfB = document.getElementById("dateOfBirth").value;
	IDNo = document.getElementById("idNo").value;
	PassPort = document.getElementById("passNo").value;
	maidenName = document.getElementById("maidenName").value;
	countryOfOri = document.getElementById("country").value;
	lastTertiary = document.getElementById("lastTertia").value;
	highGrade = document.getElementById("highGrade").value;
	schoolMatric = document.getElementById("schoolMatric").value;
	yearMatrc = document.getElementById("matricFinish").value;
	grade12No = document.getElementById("examNo").value;
	postalA = document.getElementById("postalAdd").value;
	postalB = document.getElementById("postalAdd2").value;
	postalCod = document.getElementById("postalCode").value;
	email = document.getElementById("email").value;
	cellPhne = document.getElementById("cellphone").value;
    
    
        document.getElementById("display1").innerHTML = "Course Intended to Study: ";
	document.getElementById("display").innerHTML = returnCourse();
        document.getElementById("display022").innerHTML = "Surname:";
	document.getElementById("display2").innerHTML += surname;
        document.getElementById("display033").innerHTML = "Full Names:";
	document.getElementById("display3").innerHTML += names;
        document.getElementById("display44").innerHTML = "Initials:";
	document.getElementById("display4").innerHTML += initials;
        document.getElementById("display55").innerHTML = "Preferred (Nick) Name:";
	document.getElementById("display5").innerHTML += nickName;
        document.getElementById("display66").innerHTML = "Title:";
	document.getElementById("display6").innerHTML += returnTitle();
        document.getElementById("display77").innerHTML = "Date of Birth:";
	document.getElementById("display7").innerHTML += dateOfB;
        document.getElementById("display88").innerHTML = "ID Number:";
	document.getElementById("display8").innerHTML += IDNo;
        document.getElementById("display99").innerHTML = "Passport Number(only applicable to international applicants/students): ";
	document.getElementById("display9").innerHTML += PassPort;
        document.getElementById("display100").innerHTML = "Gender:";
	document.getElementById("display10").innerHTML += genderDet();
        document.getElementById("display111").innerHTML = "Marital Status:";
	document.getElementById("display11").innerHTML += returnMarriage();
        document.getElementById("display122").innerHTML = "If married, maiden name:";
	document.getElementById("display12").innerHTML += maidenName;
        document.getElementById("display133").innerHTML = "Home language:";
	document.getElementById("display13").innerHTML += returnHome();
        document.getElementById("display144").innerHTML = "Population group:";
	document.getElementById("display14").innerHTML += returnPopGroup();
        document.getElementById("display155").innerHTML = "Church Affiliation:";
	document.getElementById("display15").innerHTML += returnChurch();
        document.getElementById("display166").innerHTML = "Citizenship:";
	document.getElementById("display16").innerHTML += returnCitizen();
        document.getElementById("display177").innerHTML = "Country of Origin:";
	document.getElementById("display17").innerHTML += countryOfOri;
        document.getElementById("display188").innerHTML = "Where did you hear about TUT:";
	document.getElementById("display18").innerHTML += returnHearOFTut();
        document.getElementById("display199").innerHTML = "Citizenship Type:";
        document.getElementById("display19").innerHTML += returnCitizenType();
        document.getElementById("display200").innerHTML = "What is your present activity before you started studies:";
	document.getElementById("display20").innerHTML += returnPreviouAct();
        document.getElementById("display211").innerHTML = "Last Tertiary Institution you attended:";
	document.getElementById("display21").innerHTML += lastTertiary;
        document.getElementById("display222").innerHTML = "Do you require exemption of subjects:";
	document.getElementById("display22").innerHTML += exemptionDet();
        document.getElementById("display233").innerHTML = "Highest grade passed:";
	document.getElementById("display23").innerHTML += highGrade;
        document.getElementById("display244").innerHTML = "School where you have/will pass you grade 12:";
	document.getElementById("display24").innerHTML += schoolMatric;
        document.getElementById("display255").innerHTML = "Year and month in which grade 12 will has been passed:";
	document.getElementById("display25").innerHTML += yearMatrc;
        document.getElementById("display266").innerHTML = "Type of leaving certificate:";
	document.getElementById("display26").innerHTML += returnMatricType();
        document.getElementById("display277").innerHTML = "Grade 12 Examination Number:";
	document.getElementById("display27").innerHTML += grade12No;
        document.getElementById("display288").innerHTML = "Do you require accommodation:";
	document.getElementById("display28").innerHTML += accomodationDet();
        document.getElementById("display299").innerHTML = "Do you require financial assistance:";
	document.getElementById("display29").innerHTML += financeAssistDet();
        document.getElementById("display300").innerHTML = "Are you currently employed:";
	document.getElementById("display30").innerHTML += emmplyedDet();
        document.getElementById("display311").innerHTML = "Postal Address:";
	document.getElementById("display31").innerHTML += postalA;
        document.getElementById("display322").innerHTML = "Postal Address:";
	document.getElementById("display32").innerHTML += postalB;
        document.getElementById("display333").innerHTML = "Postal Code:";
	document.getElementById("display33").innerHTML += postalCod;
        document.getElementById("display344").innerHTML = "Email address:";
	document.getElementById("display34").innerHTML += email;
        document.getElementById("display355").innerHTML = "Cell Phone:";
	document.getElementById("display35").innerHTML += cellPhne;
           
}
