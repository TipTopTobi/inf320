//
//  DemoPrototypeCell.swift
//  HelloCities
//
//  Created by Chihau Chau on 17-11-16.
//  Copyright © 2016 Chihau Chau. All rights reserved.
//

import UIKit

class DemoPrototypeCell: UITableViewCell {

    @IBOutlet weak var cityLabel: UILabel!
    
    @IBOutlet weak var stateLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
