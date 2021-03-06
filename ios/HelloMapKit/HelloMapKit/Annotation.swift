//
//  Annotation.swift
//  HelloMapKit
//
//  Created by Chihau Chau on 17-11-16.
//  Copyright © 2016 Chihau Chau. All rights reserved.
//

import MapKit

class Annotation: NSObject, MKAnnotation {
    let title: String?
    let subtitle: String?
    let coordinate: CLLocationCoordinate2D
    
    init(title: String, subtitle: String, coordinate: CLLocationCoordinate2D) {
        self.title = title
        self.subtitle = subtitle
        self.coordinate = coordinate
        
        super.init()
    }
    
}
